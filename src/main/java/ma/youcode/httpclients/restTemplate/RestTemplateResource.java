package ma.youcode.httpclients.restTemplate;

import lombok.RequiredArgsConstructor;
import ma.youcode.httpclients.model.Post;
import ma.youcode.httpclients.utils.JsonPlaceHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/rest-template")
@RequiredArgsConstructor
public class RestTemplateResource {

    private final RestTemplate restTemplate;

    @GetMapping
    public Post[] getAll() {
        return restTemplate.getForObject(JsonPlaceHolder.ALL_POSTS, Post[].class);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") String id) {
        return restTemplate.getForObject(JsonPlaceHolder.UNIQUE_POST+id, Post.class);
    }
}
