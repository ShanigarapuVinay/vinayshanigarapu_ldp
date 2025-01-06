import React from "react";
import Summary from "../../Organisms/Summary/Summary";
import "./summaryLayout.css";


const summaryInfo = [
  {
    mainText: "Term",
    subText: "12 months",
  },
  {
    mainText: "Selected contracts",
    subText: "2",
  },
  {
    mainText: "Pay back amount",
    subText: "$170,454.55",
  },
  {
    mainText: "Rate %",
    subText: "$20,454.55",
  },
];
const SummaryLayout: React.FC = () => {
  return (
    <div className="summary-layout">
      <Summary summaryInfo={summaryInfo} />
    </div>
  );
};

export default SummaryLayout;
