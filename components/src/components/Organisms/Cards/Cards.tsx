import React from "react";
import CardData, {CardDataProps} from "../../Molecules/CardData/CardData";
import './cards.css';

interface CardsProps {
    cards: CardDataProps[];
}
const Cards: React.FC<CardsProps> = ({cards}) => {
  return (
    <div className="cards">
      {cards.map((card) => (
        <CardData mainText={card.mainText} subText={card.subText} key={card.mainText} src={card.src} alt={card.alt} height={card.height}></CardData>
      ))}
    </div>
  );
};

export default Cards;
