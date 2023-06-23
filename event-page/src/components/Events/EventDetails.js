import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import './EventDetails.css';

import ConcertImage from '../../resources/Concert 2023.jpg';
import TechConfImage from '../../resources/Tech Conference 2023.jpg';
import ArtExpoImage from '../../resources/Art Expo 2023.jpg';
import CookingWorkshopImage from '../../resources/Cooking Workshop 2023.jpg';
import FilmFestivalImage from '../../resources/Film Festival 2023.jpg';

const EventDetails = () => {
    const { name } = useParams();
    const [email, setEmail] = useState('');
    const [event, setEvent] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:9191/event-service/api/events/${name}`)
            .then(response => {
                setEvent(response.data)
            })
            .catch(error => console.error(error));
    }, [name]);

    const handleBuyTicket = () => {
        const requestData = {
          email: email, // Use the email value from your component's state
        };
      
        axios
          .post(`http://localhost:8081/api/tickets/${name}`, requestData)
          .then((response) => {
            const responseBody = response.data;
      
            // Open new window/tab with the response body
            const newWindow = window.open('', '_blank');
            if (newWindow) {
              newWindow.document.write(`<pre>${JSON.stringify(responseBody, null, 2)}</pre>`);
            } else {
              console.error('Failed to open new window');
            }
      
            // Navigate to the URL of the response
            if (responseBody.url) {
              newWindow.location.href = responseBody.url;
            }
          })
          .catch((error) => console.error(error));
      
        // Open payment URL in a new tab
        window.open(`http://localhost:9191/payment-service/api/payment/${name}`, '_blank');
      };

    if (!event) {
        return <div>Loading...</div>;
    }

    const { title, location, price, date } = event;
    
    let eventImage;
    switch(name) {
        case 'Concert 2023':
            eventImage = ConcertImage;
            break;
        case 'Tech Conference 2023':
            eventImage = TechConfImage;
            break;
        case 'Art Expo 2023':
            eventImage = ArtExpoImage;
            break;
        case 'Cooking Workshop 2023':
            eventImage = CookingWorkshopImage;
            break;
        case 'Film Festival 2023':
            eventImage = FilmFestivalImage;
            break;
        default:
            eventImage = '';  // default image or empty string
    }

    return (
        <div className="event-container">
            <div className="event-image-container">
                <img src={eventImage} alt={title} className="event-image" />
            </div>

            <div className="event-details">
                <h2>{title}</h2>
                <p><strong>Location:</strong> {location}</p>
                <p><strong>Price:</strong> ${price}</p>
                <p><strong>Date:</strong> {new Date(date).toDateString()}</p>
                <label htmlFor="email-input" className="email-label">E-Posta:</label>
                <input id="email-input" type="email" className="email-input" value={email} onChange={e => setEmail(e.target.value)} />
                <button className="buy-ticket-button" onClick={handleBuyTicket}>Buy Ticket</button>
            </div>
        </div>
    );
};

export default EventDetails;
