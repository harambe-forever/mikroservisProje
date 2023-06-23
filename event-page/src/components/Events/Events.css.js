import styled, { keyframes } from 'styled-components';

export const TopBar = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.5rem;
  background: linear-gradient(to right, #f12711, #f5af19);
  color: white;
`;


export const ImageContainer = styled.div`
  flex: 1;
  height: 200px; // adjust the height as needed
  position: relative;
  
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

const scaleIn = keyframes`
  from {
    transform: scale(0.95);
  }
  to {
    transform: scale(1);
  }
`;

const scaleOut = keyframes`
  from {
    transform: scale(1);
  }
  to {
    transform: scale(0.95);
  }
`;

export const EventCard = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin: 0.5rem;
  padding: 1rem;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.4s;
  border-radius: 5px;
  cursor: pointer;
  position: relative;
  width: 150px;  
  height: 300px; 
  background: linear-gradient(to right, #f12711, #f5af19);
  
  &:hover {
    animation: ${scaleIn} 0.4s linear forwards;
  }

  &:active {
    animation: ${scaleOut} 0.4s linear forwards;
  }

  ${ImageContainer} {
    position: relative;
    z-index: 1;
  }
}`;


export const TextContainer = styled.div`
margin - top: 1rem;

h2,
  p,
  span {
  color: white;
  
}
`;

export const EventContainer = styled.div`
  padding: 1rem;
  display: flex;
  flex-wrap: wrap;
`;