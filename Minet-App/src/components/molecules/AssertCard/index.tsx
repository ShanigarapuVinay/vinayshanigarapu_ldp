import React from "react";
import Icon, { IconProps } from "../../atoms/Icon";
import { TypographyProps } from "@mui/material";
import { InnerBox, Wrapper } from "./index.styles";
import Typography from "../../atoms/Typography";

interface AssertCardProps extends IconProps {
  mainVariant: TypographyProps["variant"];
  mainColor: TypographyProps["color"];
  mainText: string;
  subVariant: TypographyProps["variant"];
  subColor: TypographyProps["color"];
  subText: string;
}
const AssertCard: React.FC<AssertCardProps> = ({
  src,
  alt,
  mainVariant,
  mainColor,
  mainText,
  subVariant,
  subColor,
  subText,
}) => {
  return (
    <Wrapper>
      <Icon src={src} alt={alt} />
      <InnerBox>
        <Typography variant={mainVariant} color={mainColor}>
          {mainText}
        </Typography>
        <Typography variant={subVariant} color={subColor}>
          {subText}
        </Typography>
      </InnerBox>
    </Wrapper>
  );
};

export default AssertCard;
