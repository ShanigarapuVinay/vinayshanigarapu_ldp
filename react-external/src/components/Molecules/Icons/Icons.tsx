import { Stack, Typography } from "@mui/material";
import Icon from "../../Atoms/Icon/Icon";

function Icons() {
  return (
    <Stack direction="row" justifyContent="space-between">
      <Stack direction="row" spacing={3} alignItems={"center"}>
        <Icon
          src={`${process.env.PUBLIC_URL}/asserts/Bike.svg`}
          height="21"
          alt="Bike"
        />
        <Icon
          src={`${process.env.PUBLIC_URL}/asserts/Bus.svg`}
          height="18"
          alt="Bus"
        />
        <Icon
          src={`${process.env.PUBLIC_URL}/asserts/Car.svg`}
          height="17"
          alt="Car"
        />
        <Icon
          src={`${process.env.PUBLIC_URL}/asserts/Train.svg`}
          height="18"
          alt="Train"
        />
      </Stack>
      <Typography variant="h3">36 min ago</Typography>
    </Stack>
  );
}

export default Icons;
