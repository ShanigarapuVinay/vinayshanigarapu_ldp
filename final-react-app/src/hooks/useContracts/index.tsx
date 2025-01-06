import { useEffect, useState } from "react";
import { Contract } from "../../types/Contract";
import axios from "axios";

const useContracts = () => {
  const [contracts, setContracts] = useState<Contract[]>([]);
  useEffect(() => {
    axios
      .get("http://localhost:5000/contracts")
      .then((response) => {
        setContracts(response.data);
      })
      .catch((error) => {
        console.error("Error fetching contracts:", error);
      });
  }, []);
  return { contracts };
};
export default useContracts;
