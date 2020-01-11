package com.app.discovery.photoappapiusers.data;

import com.app.discovery.photoappapiusers.ui.model.AlbumResponseModel;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "albums-ws", fallbackFactory = AlbumsFallback.class)
public interface AlbumsServiceClient {

    @GetMapping("/users/{id}/albums")
    List<AlbumResponseModel> getAlbums(@PathVariable String id);
}


@Component
class AlbumsFallback implements FallbackFactory<AlbumsServiceClient> {

    @Override
    public AlbumsServiceClient create(Throwable throwable) {
        return id -> new ArrayList<>();
    }
}
