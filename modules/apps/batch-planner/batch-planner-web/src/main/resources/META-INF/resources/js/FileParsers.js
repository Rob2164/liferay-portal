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

import {
	CSV_FORMAT,
	JSONL_FORMAT,
	JSON_FORMAT,
	PARSE_FILE_CHUNK_SIZE,
} from './constants';

export function parseCSV(content, separator) {
	const objPattern = new RegExp(
		'(\\' +
			separator +
			'|\\r?\\n|\\r|^)' +
			'(?:"([^"]*(?:""[^"]*)*)"|' +
			'([^"\\' +
			separator +
			'\\r\\n]*))',
		'gi'
	);

	const arrData = [[]];
	let arrMatches = objPattern.exec(content);

	while (arrMatches) {
		const strMatchedDelimiter = arrMatches[1];

		if (strMatchedDelimiter.length && strMatchedDelimiter !== separator) {
			arrData.push([]);
		}

		const strMatchedValue = arrMatches[2]
			? arrMatches[2].replace(new RegExp('""', 'g'), '"')
			: arrMatches[3];

		arrData[arrData.length - 1].push(strMatchedValue);

		arrMatches = objPattern.exec(content);
	}

	return arrData;
}

export function extractFieldsFromCSV(
	content,
	{csvContainsHeaders, csvSeparator}
) {
	if (content.indexOf('\n') > -1) {
		const splitLines = content.split('\n');

		const firstNoEmptyLine = splitLines.find((line) => line.length > 0);

		const firstLineColumns = parseCSV(firstNoEmptyLine, csvSeparator)[0];

		if (csvContainsHeaders) {
			return firstLineColumns;
		}
		else {
			return new Array(firstLineColumns.length)
				.fill()
				.map((_, index) => index);
		}
	}
}

export function extractFieldsFromJSONL(content) {
	let contentToParse;

	if (content.indexOf('\n') > -1) {
		const splitLines = content.split('\n');

		contentToParse = splitLines.find((line) => line.length > 0);
	}
	else {
		contentToParse = content;
	}

	try {
		const data = JSON.parse(contentToParse);

		return Object.keys(data);
	}
	catch (error) {
		console.error(error);

		return;
	}
}

export function extractFieldsFromJSON(content) {
	const jsonArray = content.split('');
	let parsedJSON;

	jsonArray.shift();

	for (let index = 0; index < jsonArray.length - 1; index++) {
		if (jsonArray[index] === '}') {
			const partialJson = jsonArray.slice(0, index + 1).join('');

			try {
				parsedJSON = JSON.parse(partialJson);

				return Object.keys(parsedJSON);
			}
			catch (error) {
				console.error(error);
			}
		}
	}
}

function parseInChunk({
	chunkParser,
	extension,
	file,
	onComplete,
	onError,
	options,
}) {
	let abort = false;
	const fileSize = file.size;
	let offset = 0;

	const chunkReaderBlock = (_offset, length, _file) => {
		const reader = new FileReader();

		const blob = _file.slice(_offset, length + _offset);

		reader.addEventListener('load', readEventHandler);
		reader.readAsText(blob);
	};

	const readEventHandler = (event) => {
		if (event.target.error || abort) {
			return onError();
		}

		offset += event.target.result.length;

		const schema = chunkParser(event.target.result, options);

		if (schema) {
			return onComplete({extension, schema});
		}
		else if (offset >= fileSize) {
			return onError();
		}

		chunkReaderBlock(offset, PARSE_FILE_CHUNK_SIZE, file);
	};

	chunkReaderBlock(offset, PARSE_FILE_CHUNK_SIZE, file);

	return () => {
		abort = true;
	};
}

const parseOperators = {
	[CSV_FORMAT]: extractFieldsFromCSV,
	[JSON_FORMAT]: extractFieldsFromJSON,
	[JSONL_FORMAT]: extractFieldsFromJSONL,
};

export default function parseFile({
	extension,
	file,
	onComplete,
	onError,
	options,
}) {
	parseInChunk({
		chunkParser: parseOperators[extension],
		extension,
		file,
		onComplete,
		onError,
		options,
	});
}
