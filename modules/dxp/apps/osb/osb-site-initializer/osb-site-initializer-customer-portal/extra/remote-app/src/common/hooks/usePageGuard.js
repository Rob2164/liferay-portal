import {useEffect, useState} from 'react';
import {LiferayTheme} from '../services/liferay';
import {getAccountFlagByFilter} from '../services/liferay/graphql/account-flags';
import {PARAMS_KEYS} from '../services/liferay/search-params';
import useGraphQL from './useGraphQL';

const liferaySiteName = LiferayTheme.getLiferaySiteName();

const validateExternalReferenceCode = (
	accountBriefs,
	externalReferenceCode
) => {
	const accountBrief = accountBriefs.find(
		(accountBrief) =>
			accountBrief.externalReferenceCode === externalReferenceCode
	);

	return accountBrief;
};

const onboardingPageGuard = (
	userAccount,
	accountFlags,
	externalReferenceCode
) => {
	return {
		location: `${window.location.origin}${liferaySiteName}/onboarding?${PARAMS_KEYS.PROJECT_APPLICATION_EXTERNAL_REFERENCE_CODE}=${externalReferenceCode}`,
		validate:
			!accountFlags.length &&
			userAccount.roleBriefs.find(
				({name}) => name === 'Account Administrator'
			) &&
			validateExternalReferenceCode(
				userAccount.accountBriefs,
				externalReferenceCode
			),
	};
};

const overviewPageGuard = (
	userAccount,
	_accountFlags,
	externalReferenceCode
) => {
	const isValidExternalReferenceCode = validateExternalReferenceCode(
		userAccount.accountBriefs,
		externalReferenceCode
	);
	const validation =
		isValidExternalReferenceCode || userAccount.accountBriefs.length === 1;

	const getExternalReferenceCode = () => {
		if (isValidExternalReferenceCode) {
			return externalReferenceCode;
		}
		else if (userAccount.accountBriefs.length === 1) {
			return userAccount.accountBriefs[0].externalReferenceCode;
		}
	};

	return {
		location: `${window.location.origin}${liferaySiteName}/overview?${
			PARAMS_KEYS.PROJECT_APPLICATION_EXTERNAL_REFERENCE_CODE
		}=${getExternalReferenceCode()}`,
		validate: validation,
	};
};

const usePageGuard = (
	userAccount,
	guard,
	alternativeGuard,
	externalReferenceCode
) => {
	const [isLoading, setLoading] = useState(true);

	const {data} = useGraphQL([
		getAccountFlagByFilter({
			accountKey: externalReferenceCode,
			name: 'onboarding',
			userUuid: userAccount.externalReferenceCode,
			value: 1,
		}),
	]);

	useEffect(() => {
		if (data) {
			if (
				!validateExternalReferenceCode(
					userAccount.accountBriefs,
					externalReferenceCode
				) ||
				!guard(userAccount, data.accountFlags, externalReferenceCode)
					.validate
			) {
				const {
					location,
					validate: alternativeValidate,
				} = alternativeGuard(
					userAccount,
					data.accountFlags,
					externalReferenceCode
				);

				if (alternativeValidate) {
					window.location.href = location;
				}
				else {
					window.location.href = `${window.location.origin}${liferaySiteName}`;
				}
			} else {
				setLoading(false);
			}
		}

		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [data]);

	return {
		isLoading,
	};
};

export {usePageGuard, onboardingPageGuard, overviewPageGuard};
