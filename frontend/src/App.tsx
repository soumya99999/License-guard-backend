import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './layout/Layout';
import LicenseAssignment from './components/LicenseAssignment';

function App() {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/" element={<div>Welcome to LicenseGuard Dashboard</div>} />
          <Route path="/license-assignment" element={<LicenseAssignment />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
