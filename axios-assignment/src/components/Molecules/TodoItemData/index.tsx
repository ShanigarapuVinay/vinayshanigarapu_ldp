import { ButtonProps, CheckboxProps, Container, TypographyProps } from '@mui/material'
import React from 'react'
import CheckBox from '../../Atoms/CheckBox';
import Typography from '../../Atoms/Typography';
import Button from '../../Atoms/Button';

type TodoItemProps = ButtonProps & TypographyProps & CheckboxProps;
const TodoItemData: React.FC<TodoItemProps> = ({...props}) => {
  return (
    <Container>
      <CheckBox {...props} />
      <Typography {...props} />
      <Button {...props} />
      <Button {...props} />
    </Container>
  )
}

export default TodoItemData