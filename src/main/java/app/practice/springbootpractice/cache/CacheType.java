package app.practice.springbootpractice.cache;

import lombok.Getter;

@Getter
public enum CacheType {

	MAN_DU_RUT_SAM("manDuRutSam", 60 * 60 * 24 * 7, 1);

	private final String cacheName;
	private final int secsToExpireAfterWrite;
	private final int entryMaxSize;

	CacheType(String cacheName, int secsToExpireAfterWrite, int entryMaxSize) {
		this.cacheName = cacheName;
		this.secsToExpireAfterWrite = secsToExpireAfterWrite;
		this.entryMaxSize = entryMaxSize;
	}
}