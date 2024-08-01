import { Stack } from "@mui/material";
import React from "react";
import { Constants } from "../../../constants";
import {
  StyledBox,
  StyledCardContainer,
  StyledSlider,
  StyledTypography,
} from "../../../helper/styledComponents";
import Button from "../../atoms/button";
import Buttonography from "../../molecules/buttonography";
import CardText from "../../molecules/cardtext";
import Icography from "../../molecules/icography";

interface CardProps {
  value: number;
  max: number;
  onSliderChange: (newValue: number) => void;
  selectedContractsCount: number;
}
const Card: React.FC<CardProps> = ({
  value,
  max,
  onSliderChange,
  selectedContractsCount,
}) => {
  const handleSliderChange = (event: Event, newValue: number | number[]) => {
    event.preventDefault();
    onSliderChange(newValue as number);
  };

  const handleReset = () => {
    onSliderChange(0);
  };
  return (
    <StyledCardContainer>
      <Icography
        src={Constants.INFO}
        alt="Info"
        position="right"
        text="Summary"
        variant="h3"
      />
      <StyledBox>
        <Stack direction="column" spacing={2}>
          <CardText
            mainText="Term"
            mainVariant="body1"
            subText="12 months"
            subVariant="body1"
            subColor="#E8E7F0"
          />
          <CardText
            mainText="Selected contracts"
            mainVariant="body1"
            subText={selectedContractsCount.toString()}
            subVariant="body1"
            subColor="#E8E7F0"
          />
        </Stack>
      </StyledBox>
      <StyledBox>
        <Stack direction="column" spacing={1}>
          <Buttonography
            text="Slide to autoselect"
            textVariant="body1"
            btnVariant="outlined"
            btnLabel="Reset"
            btnSize="small"
            onClick={handleReset}
          />
          <StyledSlider
            value={value}
            onChange={handleSliderChange}
            max={max}
            valueLabelDisplay="auto"
          />
          <StyledTypography variant="body1">
            <span className="value">
              $
              {value.toLocaleString(undefined, {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
              })}
            </span>{" "}
            <span className="of">selected of</span>{" "}
            <span className="max">
              $
              {max.toLocaleString(undefined, {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2,
              })}
            </span>
          </StyledTypography>
        </Stack>
      </StyledBox>
      <StyledBox>
        <Stack direction="column" spacing={2}>
          <CardText
            mainText="Pay back amount"
            mainVariant="body1"
            subText="$288,003.30"
            subVariant="body1"
            subColor="#E8E7F0"
          />
          <CardText
            mainText="Rate %"
            mainVariant="body1"
            subText="$34,560.56"
            subVariant="body1"
            subColor="#E8E7F0"
            spanText="(12.00%)"
          />
        </Stack>
      </StyledBox>
      <StyledBox>
        <hr color="#413F4D" />
      </StyledBox>
      <StyledBox>
        <CardText
          mainText="Total Payout"
          mainVariant="h5"
          subText="$253,442.50"
          subVariant="h4"
          subColor="#E8E7F0"
        />
      </StyledBox>
      <StyledBox>
        <Button variant="contained" size="large">
          {Constants.BTN}
        </Button>
      </StyledBox>
    </StyledCardContainer>
  );
};

export default Card;
