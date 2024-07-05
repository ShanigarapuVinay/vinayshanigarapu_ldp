import React from "react";
import Cards from "../../Organisms/Cards/Cards";
import QuickAccessCard from "../../Organisms/QuickAccessCard/QuickAccessCard";
import { ReactComponent as CalendarSvg } from "../../../asserts/calendar.svg";
import { ReactComponent as CreditSvg } from "../../../asserts/document-download.svg";
import { ReactComponent as InterestSvg } from "../../../asserts/percentage-square.svg";


import './cardsLayout.css';

const cards = [
  {
    children: <CalendarSvg width="40" height="40"/>,
    subText: "Term Cap",
    mainText: "12 months",
  },
  {
    children: <CreditSvg width="40" height="40"/>,
    subText: "Available credit",
    mainText: "$880.0k",
  },
  {
    children: <InterestSvg width="40" height="40"/>,
    subText: "Max interest rate",
    mainText: "12.00%",
  },
];
const CardsLayout: React.FC = () => {
  return (
    <div className="cards-layout">
      <Cards cards={cards} />
      <QuickAccessCard />
    </div>
  );
};

export default CardsLayout;
