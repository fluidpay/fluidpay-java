# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.0.0] - 2024-XX-XX

### Major Changes
- **BREAKING**: Removed JWT authentication support - SDK now uses API key-only authentication
- **BREAKING**: Removed password reset, forgot username, and forgot password functionality
- **BREAKING**: Updated Customer Vault API endpoints to use `/vault/customer` paths
- **BREAKING**: Unified payment method creation/update/delete into single methods that dynamically route based on payload

### Added
- Support for Customer Vault API with search functionality
- Support for all Recurring API endpoints (Add-Ons, Discounts, Plans, Subscriptions with search and status updates)
- Support for all Transaction API fields (idempotency, tip amounts, discounts, L3 data, processor-specific data, etc.)
- Comprehensive transaction request models supporting all API fields
- Custom deserializers for `ProcessorSpecific` and `AchSpecific` to handle empty string responses
- `@JsonIgnoreProperties(ignoreUnknown = true)` on all model classes for API resilience
- JavaDoc documentation for all public methods
- Comprehensive test suite covering all transaction types and operations

### Changed
- Updated Gradle from 6.9 to 7.5 for Java 17 compatibility
- Updated dependency syntax from `compile` to `implementation`
- Migrated tests from JUnit 4 to JUnit 5 (Jupiter)
- Improved error handling in `Utils.doRequest` to read error streams
- Refactored customer payment methods to use dynamic routing
- Updated all transaction request models to support comprehensive field sets

### Fixed
- Fixed card expiration date handling in tests
- Fixed API key creation limits handling
- Fixed transaction response deserialization for empty processor_specific fields
- Fixed customer transaction address handling

### Removed
- JWT authentication methods (`obtainJwt`, `tokenLogout`)
- Password reset functionality (`forgottenUsername`, `forgottenPassword`, `passwordReset`)
- Individual payment method type methods (replaced with unified methods)

## [1.0.0] - Previous Release
- Initial SDK release
