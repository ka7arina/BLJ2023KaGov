// IMPORTS
import React, { useEffect, useState } from 'react';
import artistService from './services/ArtistService'; 
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import './App.css';
import { Box, Button, CardActions, Typography, Collapse, Stack } from '@mui/material';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({

  palette: {
    primary: {
      light: '#86b25f',
      main: '#00796b',
      dark: '#486f27',
      contrastText: '#fff',
    },
    secondary: {
      light: '#ff7961',
      main: '#f44336',
      dark: '#ba000d',
      contrastText: '#000',
    },
  },
});

const App: React.FC = () => {
  const [artists, setArtists] = useState<any[]>([]); 
  const [albums, setAlbums] = useState<{ [key: string]: any[] }>({}); 
  const [tracks, setTopTracks] = useState<{ [key: string]: any[] }>({});
  const [error, setError] = useState<string | null>(null);
  const [openArtistId, setOpenArtistId] = useState<string | null>(null);
  const [query, setQuery] = useState("");

  // ARRAY TO STORE ARTISTS AND THEIR IDS
  const artistArray = [
    {artistId: '1GmsPCcpKgF9OhlNXjOsbS', name: 'Lizzy Mcalpine', keywords: 'us'},
    {artistId: '2RVvqRBon9NgaGXKfywDSs', name: 'Maise Peters', keywords: 'uk'},
    {artistId: '4tuJ0bMpJh08umKkEXKUI5', name: 'Gracie Abrams', keywords: 'us'},
    {artistId: '3l0CmX0FuQjFxr8SK7Vqag', name: 'Clairo', keywords: 'us'},
    {artistId: '69761NObDw2KwmmFgZmxzC', name: 'Lexi Jayde', keywords: 'us'},
    {artistId: '06HL4z0CvFAxyc27GXpf02', name: 'Taylor Swift', keywords: 'us'},
    {artistId: '7GlBOeep6PqTfFi59PTUUN', name: 'Chappell Roan', keywords: 'us'},
    {artistId: '35l9BRT7MXmM8bv2WDQiyB', name: 'beabadoobee', keywords: 'uk'},
    {artistId: '5RJFJWYgtgWktosLrUDzff', name: 'Griff', keywords: 'uk'},
    {artistId: '1McMsnEElThX1knmY4oliG', name: 'Olivia Rodrigo', keywords: 'us'},
    {artistId: '2hUYKu1x0UZQXvzCmggvSn', name: 'Reneé Rapp', keywords: 'us'},
    {artistId: '1A6HBLulvBFzNtlMb7b08f', name: 'Angelina Mango', keywords: 'italy'},
  ];

  useEffect(() => {
    // SAVES THE HARDCODED ACCESS TOKEN
    localStorage.setItem('accessToken', 'BQASrg-K7QHOCB0sW0mf4XqvWyIzdxdSCxXsQoRm0BvLi4zsXPZ9GJkzn4fHzIEHJeRIqcQc5DxI-cMbFXsqmeFNBagcXdqQcr-pesJfrO3v-UaA5NI'); 

    // FETCHES THE ARTIST DATA FROM THE ARRAY
    const fetchArtistsData = async () => {
      try {
        const artistIds = artistArray.map(artist => artist.artistId);
        const artistsData = await artistService.getArtists(artistIds);
        setArtists(artistsData);

        for (const artist of artistsData) {
          const artistAlbums = await artistService.getArtistAlbums(artist.id);
          setAlbums(prev => ({ ...prev, [artist.id]: Array.isArray(artistAlbums) ? artistAlbums : [] }));

          const artistTopTracks = await artistService.getArtistTopTracks(artist.id);
          setTopTracks(prev => ({ ...prev, [artist.id]: Array.isArray(artistTopTracks) ? artistTopTracks : [] }));
        }
      } catch (error) {
        console.error('Error fetching artist data:', error);
        setError('Error fetching artist data');
      }
    };

    fetchArtistsData();
  }, []);

  // HANDLES THE OPENING OF THE 'MORE' BUTTON
  const handleOpen = (artistId: string) => {
    setOpenArtistId(openArtistId === artistId ? null : artistId);
  };

  if (error) {
    return <div>{error}</div>;
  }

  if (artists.length === 0) {
    return <div>Loading...</div>;
  }

  // ARTIST SEARCH FEATURE
  const artistSearch = artists.filter(artist => 
    artist.name.toLowerCase().includes(query.toLowerCase())
  );

  return (
    <ThemeProvider theme={theme}>
      {/* NAV BAR */}
      <AppBar position="fixed" color="primary">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            the alt girlies
          </Typography>
          <Button color="inherit"> </Button>
        </Toolbar>
      </AppBar>
      <Toolbar /> {/* This is to offset the height of the fixed AppBar */}

      {/* MAIN CONTENT */}
      <div className="container" style={{ marginTop: '64px' }}>
        {/* SEARCH BAR */}
        <div className="input-box">
          <input
            type="search"
            name="search-form"
            id="search-form"
            className="search-input"
            onChange={(e) => setQuery(e.target.value)}
            placeholder="Search for an Artist or Genre"
          />
        </div>

        {/* ARTIST CARDS */}
        <div>
          {artistSearch.map(artist => (
            <div key={artist.id}>
              <Box sx={{ minWidth: 275 }}>
                <Card className="artistCard" variant="outlined">
                  <CardContent>
                    <Typography variant="h5" component="div">
                      Artist: {artist.name}
                    </Typography>
                    <Typography sx={{ mb: 1.5 }} color="text.secondary">
                      Genre: {artist.genres.join(', ')}
                    </Typography>
                    {artist.images && artist.images.length > 0 && (
                      <img src={artist.images[0].url} alt={artist.name} width={200} />
                    )}
                  </CardContent>
                  <CardActions>
                    <Button size="small" onClick={() => handleOpen(artist.id)}>
                      {openArtistId === artist.id ? "Show Less" : "More"}
                    </Button>
                  </CardActions>
                  <Collapse in={openArtistId === artist.id} timeout="auto" unmountOnExit>
                    <CardContent>
                      <Typography variant="h6">Albums/EP's</Typography>
                      <ul>
                        {albums[artist.id] && albums[artist.id].length > 0 ? (
                          albums[artist.id].map(album => (
                            <li key={album.id} className="album-item">
                              <h5>{album.name}</h5>
                              {album.images && album.images.length > 0 && (
                                <img src={album.images[0].url} alt={album.name} width={100} />
                              )}
                            </li>
                          ))
                        ) : (
                          <p>No albums found.</p>
                        )}
                      </ul>
                      <Typography variant="h6">Top Tracks</Typography>
                      <ul>
                        {tracks[artist.id] && tracks[artist.id].length > 0 ? (
                          tracks[artist.id].slice(0, 5).map(track => (
                            <li key={track.id} className="track-item">
                              <h5>{track.name}</h5>
                              {track.album.images && track.album.images.length > 0 && (
                                <img src={track.album.images[0].url} alt={track.name} width={100} />
                              )}
                            </li>
                          ))
                        ) : (
                          <p>No top tracks found.</p>
                        )}
                      </ul>
                    </CardContent>
                  </Collapse>
                </Card>
              </Box>
            </div>
          ))}
        </div>
      </div>
    </ThemeProvider>
  );
};

export default App;
