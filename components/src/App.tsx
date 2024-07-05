import './App.css';
import CardsLayout from './components/Template/CardsLayout/CardsLayout';
import SignUpLayout from './components/Template/SignUpLayout/SignUpLayout';
import SummaryLayout from './components/Template/SummaryLayout/SummaryLayout';

function App() {
  return (
    <div className="App">
      <SignUpLayout />
      <CardsLayout />
      <SummaryLayout />
    </div>
  );
}

export default App;
