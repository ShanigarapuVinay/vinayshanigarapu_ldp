import React from "react";
import Cards from "../../Organisms/Cards/Cards";
import QuickAccessCard from "../../Organisms/QuickAccessCard/QuickAccessCard";

import "./cardsLayout.css";

const cards = [
  {
    src: `/asserts/calendar.svg`,
    alt: "Calendar",
    height: "40px",
    subText: "Term Cap",
    mainText: "12 months",
  },
  {
    src: `/asserts/document-download.svg`,
    alt: "Credit",
    height: "40px",
    subText: "Available credit",
    mainText: "$880.0k",
  },
  {
    src: `/asserts/percentage-square.svg`,
    alt: "Percentage",
    height: "40px",
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
