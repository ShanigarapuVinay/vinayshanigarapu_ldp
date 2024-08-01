import { TypographyProps } from "@mui/material";
import React from "react";
import Typography from "../../atoms/typography";

interface HeaderProps {
  mainText: string;
  mainVariant: TypographyProps["variant"];
  secondaryText: string;
  secondaryVariant: TypographyProps["variant"];
}
const HeaderText: React.FC<HeaderProps> = ({
  mainText,
  mainVariant,
  secondaryText,
  secondaryVariant,
}) => {
  return (
    <div>
      <Typography variant={mainVariant}>{mainText}</Typography>
      <Typography variant={secondaryVariant}>{secondaryText}</Typography>
    </div>
  );
};

export default HeaderText;
