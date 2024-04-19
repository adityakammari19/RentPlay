import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import PlaygroundList from "./PlaygroundList";
import BookingList from "./BookingList";
import {
  retriveAllBookingsByUsernameApi,
  retriveAllPlaygroundsApi,
} from "../services/ApiService";
function UserHome() {
  const { username } = useParams();

  const [playgrounds, setPlaygrounds] = useState([]);
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    handleRetrieveAllPlaygroundsApi();
    handleRetrieveAllBookingsByUsernameApi();
  }, []);
 

  function handleRetrieveAllPlaygroundsApi() {
    // setLoading(true);

    retriveAllPlaygroundsApi()
      .then((response) => {
        setPlaygrounds(response.data);
      })
      .catch((error) => console.log(error))
      .finally(() => {
        // setLoading(false);
        console.log("cleanup");
      });
  }
  function handleRetrieveAllBookingsByUsernameApi() {
    // setLoading(true);

    retriveAllBookingsByUsernameApi(username)
      .then((response) => {
        setBookings(response.data);
      })
      .catch((error) => console.log(error))
      .finally(() => {
        // setLoading(false);
        console.log("cleanup");
      });
  }

  return (
    <>
      <h1>UserHome</h1>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            RentPlay
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Booking History
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Profile
                </a>
              </li>
            </ul>
            <form className="d-flex">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button className="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </div>
      </nav>
      <h1>Welcome {username}</h1>
      <PlaygroundList playgrounds = {playgrounds} />

      <BookingList bookings= {bookings} />
       
    </>
  );
}

export default UserHome;
