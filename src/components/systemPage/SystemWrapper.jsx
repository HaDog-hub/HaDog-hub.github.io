/* eslint-disable react/prop-types */
import { useEffect, useState } from "react";
import HeaderWrapper from "./header/HeaderWrapper";
import "./SystemPage.css";
import axios from "axios";

function SystemWrapper({fullTogglePage, nowUsername}) {
  const BASE_URL = 'http://localhost:8080';

  const [user, setUser] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await axios.get(`${BASE_URL}/api/system/user/${nowUsername}`);
        setUser(response.data);
      } catch {
        setError("Can not find the user.")
      }
    };
  
    if (nowUsername) {
      fetchUserData();
    }
  }, [nowUsername]);
  

  if (error) {
    return <div>Error: {error}</div>;
  }

  return <div className="system-wrapper">
    <HeaderWrapper fullTogglePage={fullTogglePage} user={user}/>
  </div>
}

export default SystemWrapper;