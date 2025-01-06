import { ThemeProvider } from "@emotion/react";
import './App.css';
import CashKick from "./components/template/cashKick";
import theme from "./helper/theme";


function App() {
  return (
    <ThemeProvider theme={theme}>
      <CashKick />
    </ThemeProvider>
  );
}

export default App;
