import React, { useState, useEffect } from 'react';
import axios from 'axios'; // import axios
import { AiOutlinePlus } from 'react-icons/ai';
import { EventContainer, TopBar, EventCard, ImageContainer, TextContainer } from './Events.css.js';
import { Link } from 'react-router-dom';
import concertImage from '../../resources/Concert 2023.jpg';
import techConferenceImage from '../../resources/Tech Conference 2023.jpg';
import artExpoImage from '../../resources/Art Expo 2023.jpg';
import cookingWorkshopImage from '../../resources/Cooking Workshop 2023.jpg';
import filmFestivalImage from '../../resources/Film Festival 2023.jpg';

const Events = () => {
    const [events, setEvents] = useState([]);

    // Define an array of your images
    const eventImages = [
        concertImage, 
        techConferenceImage, 
        artExpoImage, 
        cookingWorkshopImage, 
        filmFestivalImage
    ];

    useEffect(() => {
        axios.get('http://localhost:9191/event-service/api/events') 
            .then(response => {
                setEvents(response.data)
            })
            .catch(error => console.error(error));
    }, []);

    const [isPlusButtonHovered, setIsPlusButtonHovered] = useState(false);

    const handlePlusButtonHover = () => {
        setIsPlusButtonHovered(true);
    };

    const handlePlusButtonLeave = () => {
        setIsPlusButtonHovered(false);
    };

    return (
        <div>
            <TopBar>
                <h1>Etkinlikler</h1>
                <AiOutlinePlus
                    size={32}
                    onMouseEnter={handlePlusButtonHover}
                    onMouseLeave={handlePlusButtonLeave}
                    style={{ transform: isPlusButtonHovered ? 'scale(1.1)' : 'scale(1)' }}
                />
            </TopBar>
            <EventContainer>
                {events.map((event, index) => (
                    <Link to={`/events/${event.name}`} key={event.name}>
                        <EventCard key={event.name}>
                            <ImageContainer>
                                <img src={eventImages[index]} alt={event.title} style={{width: "100%", height: "auto"}} /> {/* Using the image at the corresponding index */}
                            </ImageContainer>
                            <TextContainer>
                                <h2>{event.title}</h2>
                                <p>{event.description}</p>
                                <div>
                                    <span>{`Price: ${event.price}`}</span>
                                    <span>{`Date: ${event.date}`}</span>
                                </div>
                            </TextContainer>
                        </EventCard>
                    </Link>
                ))}
            </EventContainer>
        </div>
    );
};

export default Events;
