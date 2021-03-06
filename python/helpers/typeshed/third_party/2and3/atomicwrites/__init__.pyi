import contextlib
import os
import sys
import tempfile
from typing import Any, AnyStr, Callable, IO, Iterator, Text
def replace_atomic(src: AnyStr, dst: AnyStr) -> None: ...
def move_atomic(src: AnyStr, dst: AnyStr) -> None: ...
class AtomicWriter(object):
    def __init__(self, path: AnyStr, mode: Text='w', overwrite: bool=False) -> None: ...
    def open(self) -> contextlib.ContextManager[IO]: ...
    def _open(self, get_fileobject: Callable) -> contextlib.ContextManager[IO]: ...
    def get_fileobject(self, dir: AnyStr=None, **kwargs) -> IO: ...
    def sync(self, f: IO) -> None: ...
    def commit(self, f: IO) -> None: ...
    def rollback(self, f: IO) -> None: ...
def atomic_write(path: AnyStr, writer_cls: type=AtomicWriter, **cls_kwargs) -> contextlib.ContextManager[IO]: ...
