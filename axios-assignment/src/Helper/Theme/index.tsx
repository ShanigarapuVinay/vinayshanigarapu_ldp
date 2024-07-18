import { createTheme } from "@mui/material";

const theme = createTheme({
    typography: {
        fontFamily: "Merriweather",
        h1: {
            fontSize: "2rem",
            fontWeight: 700,
            marginTop: "2rem",
            marginBottom: "2rem",
        },
        h4: {
            fontSize: "1.7rem",
            fontWeight: 700
        },
    },
    components: {
        MuiFormControl: {
            styleOverrides: {
                root: {
                    gap: 10,
                    width: 300,
                }
            }
        }
    }
});
export default theme;