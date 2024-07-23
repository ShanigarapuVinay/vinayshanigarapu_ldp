import { Container, Stack, Tab, Tabs } from "@mui/material";
import React from "react";
import Typography from "../../Atoms/Typography/Typography";
import { Text } from "../../../Constants/Text";

interface LibraryProps {
  tabIndex: number;
  setTabIndex: (index: number) => void;
  children: React.ReactNode;
}
const Library: React.FC<LibraryProps> = ({
  tabIndex,
  setTabIndex,
  children,
}) => {
  return (
    <Container>
      <Typography variant="h1">{Text.TITLE}</Typography>
      <Tabs
        value={tabIndex}
        onChange={(e, newValue) => setTabIndex(newValue)}
        aria-label="library tabs"
      >
        <Tab label="Currently reading" />
        <Tab label="Finished" />
      </Tabs>
      <Stack direction="row" flexWrap="wrap" gap={5}>
        {children}
      </Stack>
    </Container>
  );
};

export default Library;
