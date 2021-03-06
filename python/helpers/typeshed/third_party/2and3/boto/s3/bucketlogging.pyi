# Stubs for boto.s3.bucketlogging (Python 3.5)
#
# NOTE: This dynamically typed stub was automatically generated by stubgen.

from typing import Any, Optional

class BucketLogging:
    target = ...  # type: Any
    prefix = ...  # type: Any
    grants = ...  # type: Any
    def __init__(self, target: Optional[Any] = ..., prefix: Optional[Any] = ..., grants: Optional[Any] = ...) -> None: ...
    def add_grant(self, grant): ...
    def startElement(self, name, attrs, connection): ...
    def endElement(self, name, value, connection): ...
    def to_xml(self): ...
