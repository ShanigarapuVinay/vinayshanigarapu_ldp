import React from "react";
import Logo from "../../Atoms/Logo/Logo";
import Poster from "../../Atoms/Poster/Poster";
import './posterField.css';

const PosterField: React.FC = () => {
  return (
    <div className="poster-field">
      <Logo />
      <Poster />
    </div>
  );
};

export default PosterField;
