import { ThemeProvider } from "@emotion/react";
import Trading from "./components/organisms/Trading";
import { theme } from "./theme";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Trading />
    </ThemeProvider>
  );
}

export default App;
