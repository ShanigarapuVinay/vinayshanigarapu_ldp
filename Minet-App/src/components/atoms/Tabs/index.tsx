import React from "react";
import { StyledTab, StyledTabs } from "./index.styles";
import { TABS } from "../../../utils/Constants";

interface TabsProps {
  value: number;
  onChange: (event: React.SyntheticEvent, newValue: number) => void;
}

const Tabs: React.FC<TabsProps> = ({ value, onChange }) => {
  return (
    <StyledTabs value={value} onChange={onChange}>
      {TABS.map((tab) => (
        <StyledTab key={tab.id} label={tab.label} />
      ))}
    </StyledTabs>
  );
};

export default Tabs;
