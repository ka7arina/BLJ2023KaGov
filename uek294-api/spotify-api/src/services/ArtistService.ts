import { baseInstance } from './Api'; 
const artistService = {
  getArtists: async (artistIds: string[]) => {
    try {
      const response = await baseInstance.get(`artists`, {
        params: {
          ids: artistIds.join(','), 
        },
      });
      return response.data.artists; 
    } catch (error) {
      console.error('Error fetching artists:', error);
      throw error;
    }
  },

  getArtistAlbums: async (artistId: string) => {
    try {
      const response = await baseInstance.get(`artists/${artistId}/albums`, {
        params: {
          include_groups: 'album,single', 
          market: 'US', 
        },
      });
      
      const albums = await Promise.all(
        response.data.items.map(async (album: any) => {
          const albumDetails = await baseInstance.get(`albums/${album.id}`);
          return {
            ...album,
            total_tracks: albumDetails.data.total_tracks,
          };
        })
      );

      return albums.filter(album => album.total_tracks >= 4); 
    } catch (error) {
      console.error('Error fetching artist albums:', error);
      throw error;
    }
  },

  getArtistTopTracks: async (artistId: string, country: string = 'US') => {
    try {
      const response = await baseInstance.get(`artists/${artistId}/top-tracks?market=${country}`);
      return response.data.tracks; 
    } catch (error) {
      console.error('Error fetching artist top tracks:', error);
      throw error;
    }
  }
};

export default artistService;
