import { Stack, TypographyProps } from "@mui/material";
import React from "react";
import Icon from "../../atoms/icon";
import Typography from "../../atoms/typography";
interface IcographyProps {
  src: string;
  alt: string;
  text: string;
  variant: TypographyProps["variant"];
  position: "right" | "left";
  color?: TypographyProps["color"];
}
const Icography: React.FC<IcographyProps> = ({
  src,
  alt,
  position,
  text,
  variant,
  color,
}) => {
  return (
    <Stack direction="row" spacing={1.5}>
      {position === "right" ? (
        <>
          <Typography variant={variant} color={color}>{text}</Typography>
          <Icon src={src} alt={alt} />
        </>
      ) : (
        <>
          <Icon src={src} alt={alt} />
          <Typography variant={variant} color={color}>{text}</Typography>
        </>
      )}
    </Stack>
  );
};

export default Icography;
