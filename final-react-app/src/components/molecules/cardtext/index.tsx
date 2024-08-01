import { TypographyProps } from "@mui/material";
import React from "react";
import { StyledMoleculeBox, StyledTypography } from "../../../helper/styledComponents";
import Typography from "../../atoms/typography";
interface CardTextProps {
  mainText: string;
  mainVariant: TypographyProps["variant"];
  subText: string;
  subVariant: TypographyProps["variant"];
  subColor?: TypographyProps["color"];
  spanText?: string;
}
const CardText: React.FC<CardTextProps> = ({
  mainText,
  mainVariant,
  subText,
  subVariant,
  subColor,
  spanText,
}) => {
  return (
    <StyledMoleculeBox>
      <Typography variant={mainVariant}>{mainText}</Typography>
      {spanText ? (
        <StyledTypography variant={subVariant}>
          <span className="sub">{spanText}</span>{" "}
          <span className="max">{subText}</span>
        </StyledTypography>
      ) : (
        <Typography variant={subVariant} color={subColor}>
          {subText}
        </Typography>
      )}
    </StyledMoleculeBox>
  );
};

export default CardText;
