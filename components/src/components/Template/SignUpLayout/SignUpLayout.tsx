import React from "react";
import PosterField from "../../Molecules/PosterField/PosterField";
import SignUpForm from "../../Organisms/SignUpForm/SignUpForm";
import './signUpLayout.css';

const SignUpLayout: React.FC = () => {
  return (
    <div className="sign-up-layout">
      <PosterField />
      <SignUpForm />
    </div>
  );
};

export default SignUpLayout;
