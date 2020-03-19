/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import {ClaySelect} from '@clayui/form';
import React from 'react';

const HiddenSelectInput = ({multiple, name, options, value}) => (
	<ClaySelect
		aria-label="select"
		className="form-control hide"
		id={name}
		multiple={multiple}
		name={name}
		size={multiple ? options.length : null}
	>
		{value.length ? (
			options.map((option, index) => {
				const isSelected = value.includes(option.value);

				if (isSelected) {
					return (
						<ClaySelect.Option
							defaultValue={isSelected}
							key={`hiddenSelect${index}`}
							label={option.label}
							value={option.value}
						/>
					);
				}
			})
		) : (
			<ClaySelect.Option defaultValue={value.length} disabled value="" />
		)}
	</ClaySelect>
);

export default HiddenSelectInput;
