import { Stack, Typography } from "@mui/material";
import Icon from "../../Atoms/Icon/Icon";
import { ICONS } from "../../../Constants/Icons";
import { TEXT } from "../../../Constants/texts";

function Icons() {
  return (
    <Stack direction="row" justifyContent="space-between">
      <Stack direction="row" spacing={3} alignItems={"center"}>
        <Icon src={ICONS.BIKE} height="21" alt="Bike" />
        <Icon src={ICONS.BUS} height="18" alt="Bus" />
        <Icon src={ICONS.CAR} height="17" alt="Car" />
        <Icon src={ICONS.TRAIN} height="18" alt="Train" />
      </Stack>
      <Typography variant="h3">{TEXT.TIME}</Typography>
    </Stack>
  );
}

export default Icons;
