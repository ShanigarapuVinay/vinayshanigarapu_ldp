import { Box, styled, TypographyProps } from "@mui/material";
import React from "react";
import Typography from "../../atoms/Typography";
import Icon from "../../atoms/Icon";

interface IconTypographyProps extends TypographyProps {
  src: string;
  alt?: string;
}

const Wrapper = styled(Box)({
  display: "flex",
  alignItems: "center",
});

const IconTypography: React.FC<IconTypographyProps> = ({
  src,
  alt,
  ...props
}) => {
  return (
    <Wrapper>
      <Typography variant={props.variant} color={props.color}>
        {props.children}
      </Typography>
      <Icon src={src} alt={alt} />
    </Wrapper>
  );
};

export default IconTypography;
