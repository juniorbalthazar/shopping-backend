package org.backend.shopping.web;

import java.util.Set;

record ProfileResponse(String username, Set<String> roles) {
}
