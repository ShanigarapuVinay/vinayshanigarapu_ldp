import "./App.css";
import ContractTable from "./components/ContractTable";
import { Contract } from "./types/Contract";
const contracts: Contract[] = [
  {
    name: "Contract 1",
    type: "Monthly",
    perPayment: "$12,000.25",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$126,000.00",
  },
  {
    name: "Contract 2",
    type: "Monthly",
    perPayment: "$6,000.00",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$21,000.00",
  },
  {
    name: "Contract 3",
    type: "Monthly",
    perPayment: "$6,000.00",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$63,000.00",
  },
  {
    name: "Contract 4",
    type: "Monthly",
    perPayment: "$6,000.00",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$63,000.00",
  },
  {
    name: "Contract 5",
    type: "Monthly",
    perPayment: "$6,000.00",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$63,000.00",
  },
  {
    name: "Contract 6",
    type: "Monthly",
    perPayment: "$6,000.00",
    termLength: "12 months",
    fee: "12.0%",
    payment: "$63,000.00",
  },
];
function App() {
  return (
    <div className="App">
      <ContractTable contracts={contracts} />
    </div>
  );
}

export default App;
