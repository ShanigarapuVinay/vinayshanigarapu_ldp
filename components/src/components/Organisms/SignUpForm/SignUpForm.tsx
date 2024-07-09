import React from "react";
import Button from "../../Atoms/Button/Button";
import Typography from "../../Atoms/Typography/Typography";
import InputWithIcon from "../../Molecules/InputWithIcon/InputWithIcon";
import "./signUpForm.css";

const SignUpForm: React.FC = () => {
  return (
    <div className="sign-up-form ">
      <form>
        <Typography text="Sign Up" className="title" />
        <InputWithIcon
          type="text"
          placeholder="Your Name"
          required={true}
          src={'/asserts/smile.svg'}
          alt="Your Name"
          height="24"
        />
        <InputWithIcon
          type="email"
          placeholder="Email Address"
          required={true}
          src={'/asserts/direct-notification.svg'}
          alt="Email"
          height="24"
        />
        <InputWithIcon
          type="password"
          placeholder="Password"
          required={true}
          src={'/asserts/lock.svg'}
          alt="Password"
          height="24"
        />
        <Button label="Sign Up" />
      </form>
    </div>
  );
};

export default SignUpForm;
