import React from "react";
import Typography from "../../Atoms/Typography/Typography";
import InputWithIcon from "../../Molecules/InputWithIcon/InputWithIcon";
import { ReactComponent as UsernameSvg } from "../../../asserts/smile.svg";
import { ReactComponent as EmailSvg } from "../../../asserts/direct-notification.svg";
import { ReactComponent as PasswordSvg } from "../../../asserts/lock.svg";
import Button from "../../Atoms/Button/Button";
import "./signUpForm.css";

const SignUpForm: React.FC = () => {
  return (
    <div className="sign-up-form ">
      <form>
        <Typography text="Sign Up" className="title" />
        <InputWithIcon type="text" placeholder="Your Name" required={true}>
          <UsernameSvg width="24" height="24" />{" "}
        </InputWithIcon>
        <InputWithIcon type="email" placeholder="Email Address" required={true}>
          <EmailSvg width="24" height="24" />{" "}
        </InputWithIcon>
        <InputWithIcon type="password" placeholder="Password" required={true}>
          <PasswordSvg width="24" height="24" />{" "}
        </InputWithIcon>
        <Button label="Sign Up" />
      </form>
    </div>
  );
};

export default SignUpForm;
