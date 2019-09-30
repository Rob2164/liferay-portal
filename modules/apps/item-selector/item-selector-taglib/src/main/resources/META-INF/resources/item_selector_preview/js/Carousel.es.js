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

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import React, {Component} from 'react';
import PropTypes from "prop-types";

const Arrow = ({ direction, handleClick }) => (
	<div className={`pull-${direction}`}>
		<ClayButton
			borderless
			className="icon-arrow"
			displayType="secondary"
			onClick={handleClick}
			size="lg"
		>
			<ClayIcon symbol={`angle-${direction}`} />
		</ClayButton>
	</div>
);

const ImageSlide = ({ url }) => {
	const styles = {
		cursor: "pointer",
		maxHeight: `100%`
	};

	return <img alt="alt" src={url} style={styles} />;
};

const InfoPanel = ({ imageData }) => {
	return <h1>Info Panel</h1>;
};

const Carousel = ({currentItem, handleClickNext, handleClickPrevious, showArrows}) => (
	<div className="carousel sidenav-container">
		<div className="info-panel sidenav-menu-slider">
			<InfoPanel imageData={currentItem.metadata} />
		</div>

		<div className="sidenav-content">
			{showArrows && (
				<Arrow
					direction="left"
					handleClick={handleClickPrevious}
				/>
			)}

			<ImageSlide
				url={currentItem.url}
			/>

			{showArrows && (
				<Arrow
					direction="right"
					handleClick={handleClickNext}
				/>
			)}
		</div>
	</div>
);

export default Carousel;