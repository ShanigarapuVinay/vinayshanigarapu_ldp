import React from "react";

interface IconsProps {
  src: string;
  alt: string;
  height: string;
}

const Icons: React.FC<IconsProps> = ({ src, alt, height }) => {
  return <img src={src} alt={alt} height={height}/>;
};

export default Icons;
