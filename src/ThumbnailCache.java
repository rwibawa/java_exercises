import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class ThumbnailCache {

    public static void main(String[] args) {
        ThumbnailCache cache = new ThumbnailCache(3);

        cache.put("asset-1", new byte[]{1});
        cache.put("asset-2", new byte[]{2});
        cache.put("asset-3", new byte[]{3});

        // asset-1 becomes most recently used.
        cache.get("asset-1");

        // asset-2 is least recently used and should be evicted.
        cache.put("asset-4", new byte[]{4});

        assert cache.get("asset-2") == null;
        assert cache.get("asset-1") != null;
        assert cache.get("asset-3") != null;
        assert cache.get("asset-4") != null;
        assert cache.size() == 3;

        ThumbnailCache.Metrics metrics = cache.metrics();

        System.out.println(metrics);
    }

    private final int capacity;
    private final Map<String, byte[]> cache;

    private long hits;
    private long misses;
    private long puts;
    private long evictions;

    public ThumbnailCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero");
        }

        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public byte[] get(String assetId) {
        Objects.requireNonNull(assetId, "assetId");

        byte[] payload = cache.get(assetId);

        if (payload == null) {
            misses++;
            return null;
        }

        hits++;
        return payload;
    }

    public void put(String assetId, byte[] payload) {
        Objects.requireNonNull(assetId, "assetId");
        Objects.requireNonNull(payload, "payload");

        puts++;
        cache.put(assetId, payload);

        if (cache.size() > capacity) {
            String leastRecentlyUsed =
                    cache.keySet().iterator().next();

            cache.remove(leastRecentlyUsed);
            evictions++;
        }
    }

    public int size() {
        return cache.size();
    }

    public Metrics metrics() {
        return new Metrics(
                hits,
                misses,
                puts,
                evictions,
                cache.size()
        );
    }

    public record Metrics(
            long hits,
            long misses,
            long puts,
            long evictions,
            int currentSize) {
    }
}