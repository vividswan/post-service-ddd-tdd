package com.vividswan.postservice.common.usecase;

public interface UseCase<Request, Response> {
	Response execute(Request request);
}
