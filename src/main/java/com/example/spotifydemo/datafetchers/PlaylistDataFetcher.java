package com.example.spotifydemo.datafetchers;
import com.example.spotifydemo.datasources.SpotifyClient;
import com.example.spotifydemo.models.FeaturedPlaylists;
import com.example.spotifydemo.models.MappedPlaylist;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@DgsComponent
public class PlaylistDataFetcher {
    private final SpotifyClient spotifyClient;

    @Autowired
    public PlaylistDataFetcher(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }

    @DgsQuery
    public List<MappedPlaylist> featuredPlaylists() {
//        MappedPlaylist rockPlaylist = new MappedPlaylist();
//        rockPlaylist.setId("1");
//        rockPlaylist.setName("Rock n' Roll");
//        rockPlaylist.setDescription("A rock n' roll playlist");
//
//        MappedPlaylist popPlaylist = new MappedPlaylist();
//        popPlaylist.setId("2");
//        popPlaylist.setName("Pop");
//        popPlaylist.setDescription("A pop playlist");
//
//
//        return List.of(rockPlaylist, popPlaylist);
        FeaturedPlaylists response = spotifyClient.featuredPlaylistsRequest();
        return response.getPlaylists();
    }
    @DgsQuery
    public MappedPlaylist playlist(@InputArgument String id) {
        return spotifyClient.playlistRequest(id);
    }

}
