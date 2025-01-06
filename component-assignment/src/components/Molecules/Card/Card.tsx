import { Container, Stack } from "@mui/material";
import React, { useState } from "react";
import { TypographyProps } from "../../../Shared/Typography/TypographyProps";
import Typography from "../../Atoms/Typography/Typography";
import styled from "@emotion/styled";

interface CardProps extends TypographyProps {
  src: string;
  alt: string;
  height: string;
}

const ThemedStack = styled(Stack)(({ theme }) => ({
  alignItems: "center",
}));

const ThemedContainer = styled(Container)<{ hovered: boolean }>(
  ({ theme, hovered }) => ({
    paddingTop: 20,
    paddingBottom: 20,
    paddingLeft: 10,
    backgroundColor: "#f5f5f5",
    alignItems: "center",
    transition: "0.2s ease-in-out",
    transform: hovered ? "scale(1.05)" : "scale(1)",
    "&:hover": {
      backgroundColor: "#e0e0e0",
    },
  })
);

const CardWrapper = styled("div")({
  overflow: "hidden",
  borderRadius: "10px",
});
const Card: React.FC<CardProps> = ({
  src,
  alt,
  height,
  mainText,
  subText,
  mainTextVariant,
  subTextVariant,
}) => {
  const [hoveredItem, setHoveredItem] = useState<boolean>(false);

  const handleMouseEnter = () => {
    setHoveredItem(true);
  };

  const handleMouseLeave = () => {
    setHoveredItem(false);
  };

  return (
    <CardWrapper>
      <ThemedContainer
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
        hovered={hoveredItem}
      >
        <ThemedStack direction="row" spacing={3}>
          <img src={src} alt={alt} height={height} />
          <Stack>
            <Typography variant={mainTextVariant} label={mainText} />
            <Typography variant={subTextVariant} label={subText} />
          </Stack>
        </ThemedStack>
      </ThemedContainer>
    </CardWrapper>
  );
};

export default Card;
