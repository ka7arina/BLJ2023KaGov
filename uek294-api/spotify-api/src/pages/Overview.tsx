import artistService from '../services/ArtistService'; 

async function fetchArtist() {
    const artistId = '4tuJ0bMpJh08umKkEXKUI5?si=DnmEsooiRCCYz8ir6mkwsw';
    try {
        const artistData = await artistService.getArtist(artistId);
        console.log(artistData);
    } catch (error) {
        console.error('Error:', error);
    }
}

fetchArtist();
