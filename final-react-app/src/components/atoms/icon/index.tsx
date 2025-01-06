import React from "react";
import { Tooltip } from "@mui/material";
interface IconProps {
  src: string | undefined;
  alt: string | undefined;
  height?: string;
  width?: string;
  onClick?: () => void;
  tooltip?: string;
  style?: React.CSSProperties;
}
const Icon: React.FC<IconProps> = ({ src, alt, height, width, onClick, tooltip, style }) => {
  return (
    <Tooltip title={tooltip}>
      <img
        src={src}
        alt={alt}
        onClick={onClick}
        height={height}
        width={width}
        style={style}
      />
    </Tooltip>
  );
};

export default Icon;
