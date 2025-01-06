import { ButtonProps, TypographyProps } from "@mui/material";
import React from "react";
import { StyledMoleculeBox } from "../../../helper/styledComponents";
import Button from "../../atoms/button";
import Typography from "../../atoms/typography";
interface ButtonographyProps {
  text: string;
  textVariant: TypographyProps["variant"];
  btnLabel: string;
  btnVariant: ButtonProps["variant"];
  btnSize?: ButtonProps["size"];
  onClick: () => void;
}
const Buttonography: React.FC<ButtonographyProps> = ({
  text,
  textVariant,
  btnLabel,
  btnVariant,
  btnSize,
  onClick,
}) => {
  return (
    <StyledMoleculeBox>
      <Typography variant={textVariant}>{text}</Typography>
      <Button variant={btnVariant} size={btnSize} onClick={onClick}>
        {btnLabel}
      </Button>
    </StyledMoleculeBox>
  );
};

export default Buttonography;
