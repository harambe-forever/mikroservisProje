import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Events from './components/Events/Events.js';
import EventDetails from './components/Events/EventDetails.js';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/events" element={<Events />} />
        <Route path="/events/:name" element={<EventDetails />} /> {/* Updated line */}
      </Routes>
    </Router>
  );
}

export default App;
