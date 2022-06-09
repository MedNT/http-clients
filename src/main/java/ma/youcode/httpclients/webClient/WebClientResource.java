package ma.youcode.httpclients.webClient;

import lombok.RequiredArgsConstructor;
import ma.youcode.httpclients.model.Post;
import ma.youcode.httpclients.utils.JsonPlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("web-client")
public class WebClientResource {
    
    private final WebClient webClient;

    @GetMapping
    public Flux<Post> getAll() {
        return this.webClient.get().uri(JsonPlaceHolder.ALL_POSTS).retrieve().bodyToFlux(Post.class);
    }

    @GetMapping("/{id}")
    public Mono<Post> getById(@PathVariable("id") String id) {
        return this.webClient.get().uri(JsonPlaceHolder.UNIQUE_POST+id).retrieve().bodyToMono(Post.class);
    }
}
