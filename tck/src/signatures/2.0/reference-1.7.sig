#Signature file v4.1
#Version 2.0

CLSS public abstract interface java.io.Serializable

CLSS public abstract interface java.lang.Comparable<%0 extends java.lang.Object>
meth public abstract int compareTo({java.lang.Comparable%0})

CLSS public abstract java.lang.Enum<%0 extends java.lang.Enum<{java.lang.Enum%0}>>
cons protected <init>(java.lang.String,int)
intf java.io.Serializable
intf java.lang.Comparable<{java.lang.Enum%0}>
meth protected final java.lang.Object clone() throws java.lang.CloneNotSupportedException
meth protected final void finalize()
meth public final boolean equals(java.lang.Object)
meth public final int compareTo({java.lang.Enum%0})
meth public final int hashCode()
meth public final int ordinal()
meth public final java.lang.Class<{java.lang.Enum%0}> getDeclaringClass()
meth public final java.lang.String name()
meth public java.lang.String toString()
meth public static <%0 extends java.lang.Enum<{%%0}>> {%%0} valueOf(java.lang.Class<{%%0}>,java.lang.String)
supr java.lang.Object
hfds name,ordinal

CLSS public java.lang.Exception
cons protected <init>(java.lang.String,java.lang.Throwable,boolean,boolean)
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr java.lang.Throwable
hfds serialVersionUID

CLSS public abstract interface java.lang.Iterable<%0 extends java.lang.Object>
meth public abstract java.util.Iterator<{java.lang.Iterable%0}> iterator()

CLSS public java.lang.Object
cons public <init>()
meth protected java.lang.Object clone() throws java.lang.CloneNotSupportedException
meth protected void finalize() throws java.lang.Throwable
meth public boolean equals(java.lang.Object)
meth public final java.lang.Class<?> getClass()
meth public final void notify()
meth public final void notifyAll()
meth public final void wait() throws java.lang.InterruptedException
meth public final void wait(long) throws java.lang.InterruptedException
meth public final void wait(long,int) throws java.lang.InterruptedException
meth public int hashCode()
meth public java.lang.String toString()

CLSS public java.lang.RuntimeException
cons protected <init>(java.lang.String,java.lang.Throwable,boolean,boolean)
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr java.lang.Exception
hfds serialVersionUID

CLSS public java.lang.Throwable
cons protected <init>(java.lang.String,java.lang.Throwable,boolean,boolean)
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
intf java.io.Serializable
meth public final java.lang.Throwable[] getSuppressed()
meth public final void addSuppressed(java.lang.Throwable)
meth public java.lang.StackTraceElement[] getStackTrace()
meth public java.lang.String getLocalizedMessage()
meth public java.lang.String getMessage()
meth public java.lang.String toString()
meth public java.lang.Throwable fillInStackTrace()
meth public java.lang.Throwable getCause()
meth public java.lang.Throwable initCause(java.lang.Throwable)
meth public void printStackTrace()
meth public void printStackTrace(java.io.PrintStream)
meth public void printStackTrace(java.io.PrintWriter)
meth public void setStackTrace(java.lang.StackTraceElement[])
supr java.lang.Object
hfds CAUSE_CAPTION,EMPTY_THROWABLE_ARRAY,NULL_CAUSE_MESSAGE,SELF_SUPPRESSION_MESSAGE,SUPPRESSED_CAPTION,SUPPRESSED_SENTINEL,UNASSIGNED_STACK,backtrace,cause,detailMessage,serialVersionUID,stackTrace,suppressedExceptions
hcls PrintStreamOrWriter,SentinelHolder,WrappedPrintStream,WrappedPrintWriter

CLSS public abstract interface java.lang.annotation.Annotation
meth public abstract boolean equals(java.lang.Object)
meth public abstract int hashCode()
meth public abstract java.lang.Class<? extends java.lang.annotation.Annotation> annotationType()
meth public abstract java.lang.String toString()

CLSS public abstract interface !annotation java.lang.annotation.Documented
 anno 0 java.lang.annotation.Documented()
 anno 0 java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy value=RUNTIME)
 anno 0 java.lang.annotation.Target(java.lang.annotation.ElementType[] value=[ANNOTATION_TYPE])
intf java.lang.annotation.Annotation

CLSS public abstract interface !annotation java.lang.annotation.Retention
 anno 0 java.lang.annotation.Documented()
 anno 0 java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy value=RUNTIME)
 anno 0 java.lang.annotation.Target(java.lang.annotation.ElementType[] value=[ANNOTATION_TYPE])
intf java.lang.annotation.Annotation
meth public abstract java.lang.annotation.RetentionPolicy value()

CLSS public abstract interface !annotation java.lang.annotation.Target
 anno 0 java.lang.annotation.Documented()
 anno 0 java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy value=RUNTIME)
 anno 0 java.lang.annotation.Target(java.lang.annotation.ElementType[] value=[ANNOTATION_TYPE])
intf java.lang.annotation.Annotation
meth public abstract java.lang.annotation.ElementType[] value()

CLSS public abstract interface java.util.Collection<%0 extends java.lang.Object>
intf java.lang.Iterable<{java.util.Collection%0}>
meth public abstract <%0 extends java.lang.Object> {%%0}[] toArray({%%0}[])
meth public abstract boolean add({java.util.Collection%0})
meth public abstract boolean addAll(java.util.Collection<? extends {java.util.Collection%0}>)
meth public abstract boolean contains(java.lang.Object)
meth public abstract boolean containsAll(java.util.Collection<?>)
meth public abstract boolean equals(java.lang.Object)
meth public abstract boolean isEmpty()
meth public abstract boolean remove(java.lang.Object)
meth public abstract boolean removeAll(java.util.Collection<?>)
meth public abstract boolean retainAll(java.util.Collection<?>)
meth public abstract int hashCode()
meth public abstract int size()
meth public abstract java.lang.Object[] toArray()
meth public abstract java.util.Iterator<{java.util.Collection%0}> iterator()
meth public abstract void clear()

CLSS public abstract interface java.util.List<%0 extends java.lang.Object>
intf java.util.Collection<{java.util.List%0}>
meth public abstract <%0 extends java.lang.Object> {%%0}[] toArray({%%0}[])
meth public abstract boolean add({java.util.List%0})
meth public abstract boolean addAll(int,java.util.Collection<? extends {java.util.List%0}>)
meth public abstract boolean addAll(java.util.Collection<? extends {java.util.List%0}>)
meth public abstract boolean contains(java.lang.Object)
meth public abstract boolean containsAll(java.util.Collection<?>)
meth public abstract boolean equals(java.lang.Object)
meth public abstract boolean isEmpty()
meth public abstract boolean remove(java.lang.Object)
meth public abstract boolean removeAll(java.util.Collection<?>)
meth public abstract boolean retainAll(java.util.Collection<?>)
meth public abstract int hashCode()
meth public abstract int indexOf(java.lang.Object)
meth public abstract int lastIndexOf(java.lang.Object)
meth public abstract int size()
meth public abstract java.lang.Object[] toArray()
meth public abstract java.util.Iterator<{java.util.List%0}> iterator()
meth public abstract java.util.List<{java.util.List%0}> subList(int,int)
meth public abstract java.util.ListIterator<{java.util.List%0}> listIterator()
meth public abstract java.util.ListIterator<{java.util.List%0}> listIterator(int)
meth public abstract void add(int,{java.util.List%0})
meth public abstract void clear()
meth public abstract {java.util.List%0} get(int)
meth public abstract {java.util.List%0} remove(int)
meth public abstract {java.util.List%0} set(int,{java.util.List%0})

CLSS public abstract interface java.util.Map<%0 extends java.lang.Object, %1 extends java.lang.Object>
innr public abstract interface static Entry
meth public abstract boolean containsKey(java.lang.Object)
meth public abstract boolean containsValue(java.lang.Object)
meth public abstract boolean equals(java.lang.Object)
meth public abstract boolean isEmpty()
meth public abstract int hashCode()
meth public abstract int size()
meth public abstract java.util.Collection<{java.util.Map%1}> values()
meth public abstract java.util.Set<java.util.Map$Entry<{java.util.Map%0},{java.util.Map%1}>> entrySet()
meth public abstract java.util.Set<{java.util.Map%0}> keySet()
meth public abstract void clear()
meth public abstract void putAll(java.util.Map<? extends {java.util.Map%0},? extends {java.util.Map%1}>)
meth public abstract {java.util.Map%1} get(java.lang.Object)
meth public abstract {java.util.Map%1} put({java.util.Map%0},{java.util.Map%1})
meth public abstract {java.util.Map%1} remove(java.lang.Object)

CLSS public abstract interface java.util.Queue<%0 extends java.lang.Object>
intf java.util.Collection<{java.util.Queue%0}>
meth public abstract boolean add({java.util.Queue%0})
meth public abstract boolean offer({java.util.Queue%0})
meth public abstract {java.util.Queue%0} element()
meth public abstract {java.util.Queue%0} peek()
meth public abstract {java.util.Queue%0} poll()
meth public abstract {java.util.Queue%0} remove()

CLSS public abstract interface java.util.Set<%0 extends java.lang.Object>
intf java.util.Collection<{java.util.Set%0}>
meth public abstract <%0 extends java.lang.Object> {%%0}[] toArray({%%0}[])
meth public abstract boolean add({java.util.Set%0})
meth public abstract boolean addAll(java.util.Collection<? extends {java.util.Set%0}>)
meth public abstract boolean contains(java.lang.Object)
meth public abstract boolean containsAll(java.util.Collection<?>)
meth public abstract boolean equals(java.lang.Object)
meth public abstract boolean isEmpty()
meth public abstract boolean remove(java.lang.Object)
meth public abstract boolean removeAll(java.util.Collection<?>)
meth public abstract boolean retainAll(java.util.Collection<?>)
meth public abstract int hashCode()
meth public abstract int size()
meth public abstract java.lang.Object[] toArray()
meth public abstract java.util.Iterator<{java.util.Set%0}> iterator()
meth public abstract void clear()

CLSS public abstract interface java.util.SortedMap<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf java.util.Map<{java.util.SortedMap%0},{java.util.SortedMap%1}>
meth public abstract java.util.Collection<{java.util.SortedMap%1}> values()
meth public abstract java.util.Comparator<? super {java.util.SortedMap%0}> comparator()
meth public abstract java.util.Set<java.util.Map$Entry<{java.util.SortedMap%0},{java.util.SortedMap%1}>> entrySet()
meth public abstract java.util.Set<{java.util.SortedMap%0}> keySet()
meth public abstract java.util.SortedMap<{java.util.SortedMap%0},{java.util.SortedMap%1}> headMap({java.util.SortedMap%0})
meth public abstract java.util.SortedMap<{java.util.SortedMap%0},{java.util.SortedMap%1}> subMap({java.util.SortedMap%0},{java.util.SortedMap%0})
meth public abstract java.util.SortedMap<{java.util.SortedMap%0},{java.util.SortedMap%1}> tailMap({java.util.SortedMap%0})
meth public abstract {java.util.SortedMap%0} firstKey()
meth public abstract {java.util.SortedMap%0} lastKey()

CLSS public abstract interface java.util.SortedSet<%0 extends java.lang.Object>
intf java.util.Set<{java.util.SortedSet%0}>
meth public abstract java.util.Comparator<? super {java.util.SortedSet%0}> comparator()
meth public abstract java.util.SortedSet<{java.util.SortedSet%0}> headSet({java.util.SortedSet%0})
meth public abstract java.util.SortedSet<{java.util.SortedSet%0}> subSet({java.util.SortedSet%0},{java.util.SortedSet%0})
meth public abstract java.util.SortedSet<{java.util.SortedSet%0}> tailSet({java.util.SortedSet%0})
meth public abstract {java.util.SortedSet%0} first()
meth public abstract {java.util.SortedSet%0} last()

CLSS public abstract interface java.util.concurrent.BlockingQueue<%0 extends java.lang.Object>
intf java.util.Queue<{java.util.concurrent.BlockingQueue%0}>
meth public abstract boolean add({java.util.concurrent.BlockingQueue%0})
meth public abstract boolean contains(java.lang.Object)
meth public abstract boolean offer({java.util.concurrent.BlockingQueue%0})
meth public abstract boolean offer({java.util.concurrent.BlockingQueue%0},long,java.util.concurrent.TimeUnit) throws java.lang.InterruptedException
meth public abstract boolean remove(java.lang.Object)
meth public abstract int drainTo(java.util.Collection<? super {java.util.concurrent.BlockingQueue%0}>)
meth public abstract int drainTo(java.util.Collection<? super {java.util.concurrent.BlockingQueue%0}>,int)
meth public abstract int remainingCapacity()
meth public abstract void put({java.util.concurrent.BlockingQueue%0}) throws java.lang.InterruptedException
meth public abstract {java.util.concurrent.BlockingQueue%0} poll(long,java.util.concurrent.TimeUnit) throws java.lang.InterruptedException
meth public abstract {java.util.concurrent.BlockingQueue%0} take() throws java.lang.InterruptedException

CLSS public abstract interface java.util.concurrent.ConcurrentMap<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf java.util.Map<{java.util.concurrent.ConcurrentMap%0},{java.util.concurrent.ConcurrentMap%1}>
meth public abstract boolean remove(java.lang.Object,java.lang.Object)
meth public abstract boolean replace({java.util.concurrent.ConcurrentMap%0},{java.util.concurrent.ConcurrentMap%1},{java.util.concurrent.ConcurrentMap%1})
meth public abstract {java.util.concurrent.ConcurrentMap%1} putIfAbsent({java.util.concurrent.ConcurrentMap%0},{java.util.concurrent.ConcurrentMap%1})
meth public abstract {java.util.concurrent.ConcurrentMap%1} replace({java.util.concurrent.ConcurrentMap%0},{java.util.concurrent.ConcurrentMap%1})

CLSS public abstract interface java.util.concurrent.locks.Lock
meth public abstract boolean tryLock()
meth public abstract boolean tryLock(long,java.util.concurrent.TimeUnit) throws java.lang.InterruptedException
meth public abstract java.util.concurrent.locks.Condition newCondition()
meth public abstract void lock()
meth public abstract void lockInterruptibly() throws java.lang.InterruptedException
meth public abstract void unlock()

CLSS public abstract interface java.util.concurrent.locks.ReadWriteLock
meth public abstract java.util.concurrent.locks.Lock readLock()
meth public abstract java.util.concurrent.locks.Lock writeLock()

CLSS public org.terracotta.toolkit.InvalidToolkitConfigException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitInstantiationException

CLSS public abstract interface org.terracotta.toolkit.Toolkit
meth public abstract <%0 extends java.lang.Comparable<? super {%%0}>, %1 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitSortedMap<{%%0},{%%1}> getSortedMap(java.lang.String,java.lang.Class<{%%0}>,java.lang.Class<{%%1}>)
meth public abstract <%0 extends java.lang.Comparable<? super {%%0}>> org.terracotta.toolkit.collections.ToolkitSortedSet<{%%0}> getSortedSet(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object, %1 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitMap<{%%0},{%%1}> getMap(java.lang.String,java.lang.Class<{%%0}>,java.lang.Class<{%%1}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.cache.ToolkitCache<java.lang.String,{%%0}> getCache(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.cache.ToolkitCache<java.lang.String,{%%0}> getCache(java.lang.String,org.terracotta.toolkit.config.Configuration,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitBlockingQueue<{%%0}> getBlockingQueue(java.lang.String,int,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitBlockingQueue<{%%0}> getBlockingQueue(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitList<{%%0}> getList(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.collections.ToolkitSet<{%%0}> getSet(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.events.ToolkitNotifier<{%%0}> getNotifier(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.store.ToolkitStore<java.lang.String,{%%0}> getStore(java.lang.String,java.lang.Class<{%%0}>)
meth public abstract <%0 extends java.lang.Object> org.terracotta.toolkit.store.ToolkitStore<java.lang.String,{%%0}> getStore(java.lang.String,org.terracotta.toolkit.config.Configuration,java.lang.Class<{%%0}>)
meth public abstract <%0 extends org.terracotta.toolkit.ToolkitFeature> {%%0} getFeature(org.terracotta.toolkit.ToolkitFeatureType<{%%0}>)
meth public abstract org.terracotta.toolkit.cluster.ClusterInfo getClusterInfo()
meth public abstract org.terracotta.toolkit.concurrent.ToolkitBarrier getBarrier(java.lang.String,int)
meth public abstract org.terracotta.toolkit.concurrent.atomic.ToolkitAtomicLong getAtomicLong(java.lang.String)
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitLock getLock(java.lang.String)
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock getReadWriteLock(java.lang.String)
meth public abstract void fireOperatorEvent(org.terracotta.toolkit.monitoring.OperatorEventLevel,java.lang.String,java.lang.String)
meth public abstract void shutdown()

CLSS public final org.terracotta.toolkit.ToolkitFactory
cons public <init>()
meth public static org.terracotta.toolkit.Toolkit createToolkit(java.lang.String) throws org.terracotta.toolkit.ToolkitInstantiationException
meth public static org.terracotta.toolkit.Toolkit createToolkit(java.lang.String,java.util.Properties) throws org.terracotta.toolkit.ToolkitInstantiationException
supr java.lang.Object
hfds TOOLKIT_URI_DELIM,TOOLKIT_URI_PREFIX
hcls ToolkitFactoryServiceLookup,ToolkitTypeSubNameTuple

CLSS public abstract interface org.terracotta.toolkit.ToolkitFeature
meth public abstract boolean isEnabled()

CLSS public final org.terracotta.toolkit.ToolkitFeatureType<%0 extends org.terracotta.toolkit.ToolkitFeature>
fld public final static org.terracotta.toolkit.ToolkitFeatureType<org.terracotta.toolkit.feature.NonStopFeature> NONSTOP
fld public final static org.terracotta.toolkit.ToolkitFeatureType<org.terracotta.toolkit.feature.OffheapFeature> OFFHEAP
fld public final static org.terracotta.toolkit.ToolkitFeatureType<org.terracotta.toolkit.feature.SearchFeature> SEARCH
meth public boolean equals(java.lang.Object)
meth public int hashCode()
meth public java.lang.Class<{org.terracotta.toolkit.ToolkitFeatureType%0}> getFeatureClass()
meth public java.lang.String toString()
meth public static org.terracotta.toolkit.ToolkitFeatureType[] values()
supr java.lang.Object
hfds clazz,features

CLSS public org.terracotta.toolkit.ToolkitInstantiationException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr java.lang.Exception

CLSS public final !enum org.terracotta.toolkit.ToolkitObjectType
fld public final static org.terracotta.toolkit.ToolkitObjectType ATOMIC_LONG
fld public final static org.terracotta.toolkit.ToolkitObjectType BARRIER
fld public final static org.terracotta.toolkit.ToolkitObjectType BLOCKING_QUEUE
fld public final static org.terracotta.toolkit.ToolkitObjectType CACHE
fld public final static org.terracotta.toolkit.ToolkitObjectType LIST
fld public final static org.terracotta.toolkit.ToolkitObjectType LOCK
fld public final static org.terracotta.toolkit.ToolkitObjectType MAP
fld public final static org.terracotta.toolkit.ToolkitObjectType NOTIFIER
fld public final static org.terracotta.toolkit.ToolkitObjectType READ_WRITE_LOCK
fld public final static org.terracotta.toolkit.ToolkitObjectType SET
fld public final static org.terracotta.toolkit.ToolkitObjectType SORTED_MAP
fld public final static org.terracotta.toolkit.ToolkitObjectType SORTED_SET
fld public final static org.terracotta.toolkit.ToolkitObjectType STORE
meth public static org.terracotta.toolkit.ToolkitObjectType valueOf(java.lang.String)
meth public static org.terracotta.toolkit.ToolkitObjectType[] values()
supr java.lang.Enum<org.terracotta.toolkit.ToolkitObjectType>

CLSS public org.terracotta.toolkit.ToolkitRuntimeException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr java.lang.RuntimeException

CLSS public abstract interface org.terracotta.toolkit.api.ToolkitFactoryService
meth public abstract boolean canHandleToolkitType(java.lang.String,java.lang.String)
meth public abstract org.terracotta.toolkit.Toolkit createToolkit(java.lang.String,java.lang.String,java.util.Properties) throws org.terracotta.toolkit.ToolkitInstantiationException

CLSS public org.terracotta.toolkit.builder.NonStopConfigurationBuilder
cons public <init>()
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder enable(boolean)
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder immediateTimeout(boolean)
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder nonStopReadTimeoutBehavior(org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior)
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder nonStopWriteTimeoutBehavior(org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior)
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder searchTimeoutMillis(long)
meth public org.terracotta.toolkit.builder.NonStopConfigurationBuilder timeoutMillis(long)
meth public org.terracotta.toolkit.nonstop.NonStopConfiguration build()
supr java.lang.Object
hfds immediateTimeout,immutableOpNonStopTimeoutBehavior,isEnabled,mutableOpNonStopTimeoutBehavior,searchTimeout,timeout
hcls NonStopToolkitConfigImpl

CLSS public final org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder
cons public <init>()
meth protected void addFieldToApply(java.lang.String,java.io.Serializable)
meth protected void setCompressionEnabled(boolean)
meth protected void setConcurrency(int)
meth protected void setConfigField(java.lang.String,java.io.Serializable)
meth protected void setConsistency(org.terracotta.toolkit.store.ToolkitConfigFields$Consistency)
meth protected void setCopyOnReadEnabled(boolean)
meth protected void setLocalCacheEnabled(boolean)
meth protected void setMaxBytesLocalHeap(long)
meth protected void setMaxBytesLocalOffheap(long)
meth protected void setMaxCountLocalHeap(int)
meth protected void setOffheapEnabled(boolean)
meth public boolean isCompressionEnabled()
meth public boolean isCopyOnReadEnabled()
meth public boolean isEvictionEnabled()
meth public boolean isLocalCacheEnabled()
meth public boolean isOffheapEnabled()
meth public boolean isPinnedInLocalMemory()
meth public int getConcurrency()
meth public int getMaxTTISeconds()
meth public int getMaxTTLSeconds()
meth public int getMaxTotalCount()
meth public long getMaxBytesLocalHeap()
meth public long getMaxBytesLocalOffheap()
meth public long getMaxCountLocalHeap()
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder compressionEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder concurrency(int)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder configField(java.lang.String,java.io.Serializable)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder consistency(org.terracotta.toolkit.store.ToolkitConfigFields$Consistency)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder copyOnReadEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder evictionEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder localCacheEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxBytesLocalHeap(long)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxBytesLocalOffheap(long)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxCountLocalHeap(int)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxTTISeconds(int)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxTTLSeconds(int)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder maxTotalCount(int)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder offheapEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitCacheConfigBuilder pinnedInLocalMemory(boolean)
meth public org.terracotta.toolkit.config.Configuration build()
meth public org.terracotta.toolkit.store.ToolkitConfigFields$Consistency getConsistency()
meth public void apply(org.terracotta.toolkit.cache.ToolkitCache)
meth public void apply(org.terracotta.toolkit.store.ToolkitStore)
meth public void setPinnedInLocalMemory(boolean)
supr java.lang.Object
hfds evictionEnabled,maxTTISeconds,maxTTLSeconds,maxTotalCount

CLSS public final org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder
cons public <init>()
meth protected void addFieldToApply(java.lang.String,java.io.Serializable)
meth protected void setCompressionEnabled(boolean)
meth protected void setConcurrency(int)
meth protected void setConfigField(java.lang.String,java.io.Serializable)
meth protected void setConsistency(org.terracotta.toolkit.store.ToolkitConfigFields$Consistency)
meth protected void setCopyOnReadEnabled(boolean)
meth protected void setLocalCacheEnabled(boolean)
meth protected void setMaxBytesLocalHeap(long)
meth protected void setMaxBytesLocalOffheap(long)
meth protected void setMaxCountLocalHeap(int)
meth protected void setOffheapEnabled(boolean)
meth public boolean isCompressionEnabled()
meth public boolean isCopyOnReadEnabled()
meth public boolean isLocalCacheEnabled()
meth public boolean isOffheapEnabled()
meth public boolean isPinnedInLocalMemory()
meth public int getConcurrency()
meth public long getMaxBytesLocalHeap()
meth public long getMaxBytesLocalOffheap()
meth public long getMaxCountLocalHeap()
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder compressionEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder concurrency(int)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder configField(java.lang.String,java.io.Serializable)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder consistency(org.terracotta.toolkit.store.ToolkitConfigFields$Consistency)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder copyOnReadEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder localCacheEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder maxBytesLocalHeap(long)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder maxBytesLocalOffheap(long)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder maxCountLocalHeap(int)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder offheapEnabled(boolean)
meth public org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder pinnedInLocalMemory(boolean)
meth public org.terracotta.toolkit.config.Configuration build()
meth public org.terracotta.toolkit.store.ToolkitConfigFields$Consistency getConsistency()
meth public void apply(org.terracotta.toolkit.cache.ToolkitCache)
meth public void apply(org.terracotta.toolkit.store.ToolkitStore)
meth public void setPinnedInLocalMemory(boolean)
supr java.lang.Object

CLSS public abstract interface org.terracotta.toolkit.cache.ToolkitCache<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf java.util.concurrent.ConcurrentMap<{org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitObject
intf org.terracotta.toolkit.search.SearchableMap<{org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1}>
meth public abstract java.util.Map<{org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1}> getAll(java.util.Collection<? extends {org.terracotta.toolkit.cache.ToolkitCache%0}>)
meth public abstract java.util.Map<{org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1}> getAllQuiet(java.util.Collection<{org.terracotta.toolkit.cache.ToolkitCache%0}>)
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock createLockForKey({org.terracotta.toolkit.cache.ToolkitCache%0})
meth public abstract org.terracotta.toolkit.config.Configuration getConfiguration()
meth public abstract void addListener(org.terracotta.toolkit.cache.ToolkitCacheListener<{org.terracotta.toolkit.cache.ToolkitCache%0}>)
meth public abstract void putNoReturn({org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1})
meth public abstract void putNoReturn({org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1},long,int,int)
meth public abstract void removeListener(org.terracotta.toolkit.cache.ToolkitCacheListener<{org.terracotta.toolkit.cache.ToolkitCache%0}>)
meth public abstract void removeNoReturn(java.lang.Object)
meth public abstract void setConfigField(java.lang.String,java.io.Serializable)
meth public abstract {org.terracotta.toolkit.cache.ToolkitCache%1} getQuiet(java.lang.Object)
meth public abstract {org.terracotta.toolkit.cache.ToolkitCache%1} putIfAbsent({org.terracotta.toolkit.cache.ToolkitCache%0},{org.terracotta.toolkit.cache.ToolkitCache%1},long,int,int)

CLSS public abstract interface org.terracotta.toolkit.cache.ToolkitCacheListener<%0 extends java.lang.Object>
meth public abstract void onEviction({org.terracotta.toolkit.cache.ToolkitCacheListener%0})
meth public abstract void onExpiration({org.terracotta.toolkit.cache.ToolkitCacheListener%0})

CLSS public abstract interface org.terracotta.toolkit.cluster.ClusterEvent
innr public final static !enum Type
meth public abstract java.lang.String getDetailedMessage()
meth public abstract org.terracotta.toolkit.cluster.ClusterEvent$Type getType()
meth public abstract org.terracotta.toolkit.cluster.ClusterNode getNode()

CLSS public final static !enum org.terracotta.toolkit.cluster.ClusterEvent$Type
 outer org.terracotta.toolkit.cluster.ClusterEvent
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type NODE_ERROR
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type NODE_JOINED
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type NODE_LEFT
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type NODE_REJOINED
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type OPERATIONS_DISABLED
fld public final static org.terracotta.toolkit.cluster.ClusterEvent$Type OPERATIONS_ENABLED
meth public static org.terracotta.toolkit.cluster.ClusterEvent$Type valueOf(java.lang.String)
meth public static org.terracotta.toolkit.cluster.ClusterEvent$Type[] values()
supr java.lang.Enum<org.terracotta.toolkit.cluster.ClusterEvent$Type>

CLSS public abstract interface org.terracotta.toolkit.cluster.ClusterInfo
meth public abstract boolean areOperationsEnabled()
meth public abstract java.util.Set<org.terracotta.toolkit.cluster.ClusterNode> getNodes()
meth public abstract org.terracotta.toolkit.cluster.ClusterNode getCurrentNode()
meth public abstract void addClusterListener(org.terracotta.toolkit.cluster.ClusterListener)
meth public abstract void removeClusterListener(org.terracotta.toolkit.cluster.ClusterListener)

CLSS public abstract interface org.terracotta.toolkit.cluster.ClusterListener
meth public abstract void onClusterEvent(org.terracotta.toolkit.cluster.ClusterEvent)

CLSS public abstract interface org.terracotta.toolkit.cluster.ClusterNode
intf java.io.Serializable
meth public abstract java.lang.String getId()
meth public abstract java.net.InetAddress getAddress()

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitBlockingQueue<%0 extends java.lang.Object>
intf java.util.concurrent.BlockingQueue<{org.terracotta.toolkit.collections.ToolkitBlockingQueue%0}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitLockedObject
meth public abstract int getCapacity()

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitList<%0 extends java.lang.Object>
intf java.util.List<{org.terracotta.toolkit.collections.ToolkitList%0}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitLockedObject

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitMap<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf java.util.concurrent.ConcurrentMap<{org.terracotta.toolkit.collections.ToolkitMap%0},{org.terracotta.toolkit.collections.ToolkitMap%1}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitLockedObject

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitSet<%0 extends java.lang.Object>
intf java.util.Set<{org.terracotta.toolkit.collections.ToolkitSet%0}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitLockedObject

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitSortedMap<%0 extends java.lang.Comparable<? super {org.terracotta.toolkit.collections.ToolkitSortedMap%0}>, %1 extends java.lang.Object>
intf java.util.SortedMap<{org.terracotta.toolkit.collections.ToolkitSortedMap%0},{org.terracotta.toolkit.collections.ToolkitSortedMap%1}>
intf org.terracotta.toolkit.collections.ToolkitMap<{org.terracotta.toolkit.collections.ToolkitSortedMap%0},{org.terracotta.toolkit.collections.ToolkitSortedMap%1}>

CLSS public abstract interface org.terracotta.toolkit.collections.ToolkitSortedSet<%0 extends java.lang.Comparable<? super {org.terracotta.toolkit.collections.ToolkitSortedSet%0}>>
intf java.util.SortedSet<{org.terracotta.toolkit.collections.ToolkitSortedSet%0}>
intf org.terracotta.toolkit.collections.ToolkitSet<{org.terracotta.toolkit.collections.ToolkitSortedSet%0}>

CLSS public abstract interface org.terracotta.toolkit.concurrent.ToolkitBarrier
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract boolean isBroken()
meth public abstract int await() throws java.lang.InterruptedException,java.util.concurrent.BrokenBarrierException
meth public abstract int await(long,java.util.concurrent.TimeUnit) throws java.lang.InterruptedException,java.util.concurrent.BrokenBarrierException,java.util.concurrent.TimeoutException
meth public abstract int getParties()
meth public abstract void reset()

CLSS public abstract interface org.terracotta.toolkit.concurrent.atomic.ToolkitAtomicLong
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract boolean compareAndSet(long,long)
meth public abstract byte byteValue()
meth public abstract double doubleValue()
meth public abstract float floatValue()
meth public abstract int intValue()
meth public abstract long addAndGet(long)
meth public abstract long decrementAndGet()
meth public abstract long get()
meth public abstract long getAndAdd(long)
meth public abstract long getAndDecrement()
meth public abstract long getAndIncrement()
meth public abstract long getAndSet(long)
meth public abstract long incrementAndGet()
meth public abstract long longValue()
meth public abstract short shortValue()
meth public abstract void set(long)

CLSS public abstract interface org.terracotta.toolkit.concurrent.locks.ToolkitLock
intf java.util.concurrent.locks.Lock
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract boolean isHeldByCurrentThread()
meth public abstract java.util.concurrent.locks.Condition getCondition()
meth public abstract java.util.concurrent.locks.Condition newCondition()
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitLockType getLockType()

CLSS public final !enum org.terracotta.toolkit.concurrent.locks.ToolkitLockType
fld public final static org.terracotta.toolkit.concurrent.locks.ToolkitLockType READ
fld public final static org.terracotta.toolkit.concurrent.locks.ToolkitLockType WRITE
meth public static org.terracotta.toolkit.concurrent.locks.ToolkitLockType valueOf(java.lang.String)
meth public static org.terracotta.toolkit.concurrent.locks.ToolkitLockType[] values()
supr java.lang.Enum<org.terracotta.toolkit.concurrent.locks.ToolkitLockType>

CLSS public abstract interface org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock
intf java.util.concurrent.locks.ReadWriteLock
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitLock readLock()
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitLock writeLock()

CLSS public abstract org.terracotta.toolkit.config.AbstractConfiguration
cons public <init>()
intf org.terracotta.toolkit.config.Configuration
meth protected abstract void internalSetConfigMapping(java.lang.String,java.io.Serializable)
meth protected java.lang.Object getMappingChecked(java.lang.String)
meth public boolean getBoolean(java.lang.String)
meth public boolean hasField(java.lang.String)
meth public int getInt(java.lang.String)
meth public java.lang.String getString(java.lang.String)
meth public long getLong(java.lang.String)
meth public org.terracotta.toolkit.config.Configuration setBoolean(java.lang.String,boolean)
meth public org.terracotta.toolkit.config.Configuration setInt(java.lang.String,int)
meth public org.terracotta.toolkit.config.Configuration setLong(java.lang.String,long)
meth public org.terracotta.toolkit.config.Configuration setObject(java.lang.String,java.io.Serializable)
meth public org.terracotta.toolkit.config.Configuration setString(java.lang.String,java.lang.String)
supr java.lang.Object

CLSS public abstract interface org.terracotta.toolkit.config.Configuration
meth public abstract boolean getBoolean(java.lang.String)
meth public abstract boolean hasField(java.lang.String)
meth public abstract int getInt(java.lang.String)
meth public abstract java.io.Serializable getObjectOrNull(java.lang.String)
meth public abstract java.lang.String getString(java.lang.String)
meth public abstract java.util.Set<java.lang.String> getKeys()
meth public abstract long getLong(java.lang.String)

CLSS public abstract !enum org.terracotta.toolkit.config.SupportedConfigurationType
fld public final static org.terracotta.toolkit.config.SupportedConfigurationType BOOLEAN
fld public final static org.terracotta.toolkit.config.SupportedConfigurationType INTEGER
fld public final static org.terracotta.toolkit.config.SupportedConfigurationType LONG
fld public final static org.terracotta.toolkit.config.SupportedConfigurationType STRING
meth public abstract <%0 extends java.lang.Object> java.io.Serializable getFromConfig(org.terracotta.toolkit.config.Configuration,java.lang.String)
meth public boolean isSupported(org.terracotta.toolkit.config.SupportedConfigurationType)
meth public static boolean isTypeSupported(java.lang.Object)
meth public static org.terracotta.toolkit.config.SupportedConfigurationType getTypeForObject(java.lang.Object)
meth public static org.terracotta.toolkit.config.SupportedConfigurationType getTypeForObjectOrNull(java.lang.Object)
meth public static org.terracotta.toolkit.config.SupportedConfigurationType valueOf(java.lang.String)
meth public static org.terracotta.toolkit.config.SupportedConfigurationType[] values()
supr java.lang.Enum<org.terracotta.toolkit.config.SupportedConfigurationType>
hfds SUPPORTED_TYPES,classType

CLSS public abstract interface org.terracotta.toolkit.events.ToolkitNotificationEvent<%0 extends java.lang.Object>
meth public abstract org.terracotta.toolkit.cluster.ClusterNode getRemoteNode()
meth public abstract {org.terracotta.toolkit.events.ToolkitNotificationEvent%0} getMessage()

CLSS public abstract interface org.terracotta.toolkit.events.ToolkitNotificationListener<%0 extends java.lang.Object>
meth public abstract void onNotification(org.terracotta.toolkit.events.ToolkitNotificationEvent<{org.terracotta.toolkit.events.ToolkitNotificationListener%0}>)

CLSS public abstract interface org.terracotta.toolkit.events.ToolkitNotifier<%0 extends java.lang.Object>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract java.util.List<org.terracotta.toolkit.events.ToolkitNotificationListener<{org.terracotta.toolkit.events.ToolkitNotifier%0}>> getNotificationListeners()
meth public abstract void addNotificationListener(org.terracotta.toolkit.events.ToolkitNotificationListener<{org.terracotta.toolkit.events.ToolkitNotifier%0}>)
meth public abstract void notifyListeners({org.terracotta.toolkit.events.ToolkitNotifier%0})
meth public abstract void removeNotificationListener(org.terracotta.toolkit.events.ToolkitNotificationListener<{org.terracotta.toolkit.events.ToolkitNotifier%0}>)

CLSS public org.terracotta.toolkit.feature.FeatureNotSupportedException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitRuntimeException

CLSS public abstract interface org.terracotta.toolkit.feature.NonStopFeature
intf org.terracotta.toolkit.ToolkitFeature
meth public abstract boolean isTimedOut()
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfigurationRegistry getNonStopConfigurationRegistry()
meth public abstract void finish()
meth public abstract void start(org.terracotta.toolkit.nonstop.NonStopConfiguration)

CLSS public abstract interface org.terracotta.toolkit.feature.OffheapFeature
intf org.terracotta.toolkit.ToolkitFeature

CLSS public abstract interface org.terracotta.toolkit.feature.SearchFeature
intf org.terracotta.toolkit.ToolkitFeature

CLSS public final !enum org.terracotta.toolkit.monitoring.OperatorEventLevel
fld public final static org.terracotta.toolkit.monitoring.OperatorEventLevel CRITICAL
fld public final static org.terracotta.toolkit.monitoring.OperatorEventLevel DEBUG
fld public final static org.terracotta.toolkit.monitoring.OperatorEventLevel ERROR
fld public final static org.terracotta.toolkit.monitoring.OperatorEventLevel INFO
fld public final static org.terracotta.toolkit.monitoring.OperatorEventLevel WARN
meth public static org.terracotta.toolkit.monitoring.OperatorEventLevel valueOf(java.lang.String)
meth public static org.terracotta.toolkit.monitoring.OperatorEventLevel[] values()
supr java.lang.Enum<org.terracotta.toolkit.monitoring.OperatorEventLevel>

CLSS public abstract interface org.terracotta.toolkit.nonstop.NonStopConfiguration
meth public abstract boolean isEnabled()
meth public abstract boolean isImmediateTimeoutEnabled()
meth public abstract long getSearchTimeoutMillis()
meth public abstract long getTimeoutMillis()
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior getReadOpNonStopTimeoutBehavior()
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior getWriteOpNonStopTimeoutBehavior()

CLSS public abstract interface org.terracotta.toolkit.nonstop.NonStopConfigurationFields
fld public final static boolean DEFAULT_NON_STOP_ENABLED = true
fld public final static boolean DEFAULT_NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = false
fld public final static java.lang.String NON_STOP_ENABLED = "nonStopEnabled"
fld public final static java.lang.String NON_STOP_IMMEDIATE_TIMEOUT_ENABLED = "immediateTimeoutEnabled"
fld public final static java.lang.String NON_STOP_READ_OP_TIMEOUT_BEHAVIOR = "nonStopReadOpTimeoutBehavior"
fld public final static java.lang.String NON_STOP_SEARCH_TIMEOUT_MILLIS = "nonStopSearchTimeoutMillis"
fld public final static java.lang.String NON_STOP_TIMEOUT_MILLIS = "nonStopTimeoutMillis"
fld public final static java.lang.String NON_STOP_WRITE_OP_TIMEOUT_BEHAVIOR = "nonStopWritesOpTimeoutBehavior"
fld public final static long DEFAULT_SEARCH_TIMEOUT_MILLIS
fld public final static long DEFAULT_TIMEOUT_MILLIS
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior DEFAULT_NON_STOP_READ_TIMEOUT_BEHAVIOR
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior DEFAULT_NON_STOP_WRITE_TIMEOUT_BEHAVIOR
innr public final static !enum NonStopReadTimeoutBehavior
innr public final static !enum NonStopWriteTimeoutBehavior

CLSS public final static !enum org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior
 outer org.terracotta.toolkit.nonstop.NonStopConfigurationFields
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior EXCEPTION
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior LOCAL_READS
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior NO_OP
meth public static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior valueOf(java.lang.String)
meth public static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior[] values()
supr java.lang.Enum<org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopReadTimeoutBehavior>

CLSS public final static !enum org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior
 outer org.terracotta.toolkit.nonstop.NonStopConfigurationFields
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior EXCEPTION
fld public final static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior NO_OP
meth public static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior valueOf(java.lang.String)
meth public static org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior[] values()
supr java.lang.Enum<org.terracotta.toolkit.nonstop.NonStopConfigurationFields$NonStopWriteTimeoutBehavior>

CLSS public abstract interface org.terracotta.toolkit.nonstop.NonStopConfigurationRegistry
meth public abstract !varargs void registerForType(org.terracotta.toolkit.nonstop.NonStopConfiguration,org.terracotta.toolkit.ToolkitObjectType[])
meth public abstract long deregisterTimeoutForSearch(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract long getTimeoutForSearch(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration deregisterForInstance(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration deregisterForInstanceMethod(java.lang.String,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration deregisterForType(org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration deregisterForTypeMethod(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration getConfigForInstance(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration getConfigForInstanceMethod(java.lang.String,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration getConfigForType(org.terracotta.toolkit.ToolkitObjectType)
meth public abstract org.terracotta.toolkit.nonstop.NonStopConfiguration getConfigForTypeMethod(java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract void registerForInstance(org.terracotta.toolkit.nonstop.NonStopConfiguration,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract void registerForInstanceMethod(org.terracotta.toolkit.nonstop.NonStopConfiguration,java.lang.String,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract void registerForTypeMethod(org.terracotta.toolkit.nonstop.NonStopConfiguration,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)
meth public abstract void registerTimeoutForSearch(long,java.lang.String,org.terracotta.toolkit.ToolkitObjectType)

CLSS public org.terracotta.toolkit.nonstop.NonStopException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitRuntimeException

CLSS public abstract interface org.terracotta.toolkit.object.Destroyable
meth public abstract boolean isDestroyed()
meth public abstract void destroy()

CLSS public abstract interface org.terracotta.toolkit.object.ToolkitLockedObject
intf org.terracotta.toolkit.object.ToolkitObject
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock getReadWriteLock()

CLSS public abstract interface org.terracotta.toolkit.object.ToolkitObject
meth public abstract java.lang.String getName()

CLSS public org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitRuntimeException

CLSS public org.terracotta.toolkit.rejoin.InvalidLockStateAfterRejoinException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.rejoin.RejoinException

CLSS public org.terracotta.toolkit.rejoin.RejoinException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitRuntimeException

CLSS public org.terracotta.toolkit.search.AggregateFunction
cons public <init>(java.lang.String,org.terracotta.toolkit.search.AggregateFunction$Type)
innr public final static !enum Type
meth public java.lang.String getAttributeName()
meth public org.terracotta.toolkit.search.AggregateFunction$Type getType()
meth public static org.terracotta.toolkit.search.AggregateFunction average(java.lang.String)
meth public static org.terracotta.toolkit.search.AggregateFunction count()
meth public static org.terracotta.toolkit.search.AggregateFunction max(java.lang.String)
meth public static org.terracotta.toolkit.search.AggregateFunction min(java.lang.String)
meth public static org.terracotta.toolkit.search.AggregateFunction sum(java.lang.String)
supr java.lang.Object
hfds attributeName,type

CLSS public final static !enum org.terracotta.toolkit.search.AggregateFunction$Type
 outer org.terracotta.toolkit.search.AggregateFunction
fld public final static org.terracotta.toolkit.search.AggregateFunction$Type AVG
fld public final static org.terracotta.toolkit.search.AggregateFunction$Type COUNT
fld public final static org.terracotta.toolkit.search.AggregateFunction$Type MAX
fld public final static org.terracotta.toolkit.search.AggregateFunction$Type MIN
fld public final static org.terracotta.toolkit.search.AggregateFunction$Type SUM
meth public static org.terracotta.toolkit.search.AggregateFunction$Type valueOf(java.lang.String)
meth public static org.terracotta.toolkit.search.AggregateFunction$Type[] values()
supr java.lang.Enum<org.terracotta.toolkit.search.AggregateFunction$Type>

CLSS public org.terracotta.toolkit.search.Attribute<%0 extends java.lang.Object>
cons public <init>(java.lang.String)
meth public boolean equals(java.lang.Object)
meth public int hashCode()
meth public java.lang.String getAttributeName()
meth public java.lang.String toString()
meth public org.terracotta.toolkit.search.AggregateFunction average()
meth public org.terracotta.toolkit.search.AggregateFunction count()
meth public org.terracotta.toolkit.search.AggregateFunction max()
meth public org.terracotta.toolkit.search.AggregateFunction min()
meth public org.terracotta.toolkit.search.AggregateFunction sum()
meth public org.terracotta.toolkit.search.expression.Clause eq({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause ge({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause gt({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause le({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause lt({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause matches(java.lang.String)
meth public org.terracotta.toolkit.search.expression.Clause ne({org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause oneOf(java.util.Collection<? extends {org.terracotta.toolkit.search.Attribute%0}>)
meth public org.terracotta.toolkit.search.expression.Clause range({org.terracotta.toolkit.search.Attribute%0},{org.terracotta.toolkit.search.Attribute%0})
meth public org.terracotta.toolkit.search.expression.Clause range({org.terracotta.toolkit.search.Attribute%0},{org.terracotta.toolkit.search.Attribute%0},boolean,boolean)
supr java.lang.Object
hfds attributeName

CLSS public abstract interface org.terracotta.toolkit.search.QueryBuilder
meth public abstract !varargs org.terracotta.toolkit.search.QueryBuilder addGroupBy(org.terracotta.toolkit.search.Attribute<?>[])
meth public abstract !varargs org.terracotta.toolkit.search.QueryBuilder includeAggregator(org.terracotta.toolkit.search.AggregateFunction[])
meth public abstract !varargs org.terracotta.toolkit.search.QueryBuilder includeAttribute(org.terracotta.toolkit.search.Attribute<?>[])
meth public abstract org.terracotta.toolkit.search.QueryBuilder addClause(org.terracotta.toolkit.search.expression.Clause)
meth public abstract org.terracotta.toolkit.search.QueryBuilder addOrderBy(org.terracotta.toolkit.search.Attribute<?>,org.terracotta.toolkit.search.SortDirection)
meth public abstract org.terracotta.toolkit.search.QueryBuilder includeKeys(boolean)
meth public abstract org.terracotta.toolkit.search.QueryBuilder includeValues(boolean)
meth public abstract org.terracotta.toolkit.search.QueryBuilder maxResults(int)
meth public abstract org.terracotta.toolkit.search.ToolkitSearchQuery build()

CLSS public org.terracotta.toolkit.search.SearchException
cons public <init>()
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
supr org.terracotta.toolkit.ToolkitRuntimeException

CLSS public abstract interface org.terracotta.toolkit.search.SearchQueryResultSet
meth public abstract boolean anyCriteriaMatched()
meth public abstract java.util.List<java.lang.Object> getAggregatorResults()
meth public abstract java.util.List<org.terracotta.toolkit.search.SearchResult> getResults()

CLSS public abstract interface org.terracotta.toolkit.search.SearchResult
meth public abstract java.lang.Object getValue()
meth public abstract java.lang.Object[] getSortAttributes()
meth public abstract java.lang.String getKey()
meth public abstract java.util.List<java.lang.Object> getAggregatorResults()
meth public abstract java.util.Map<java.lang.String,java.lang.Object> getAttributes()
meth public abstract java.util.Map<java.lang.String,java.lang.Object> getGroupByValues()

CLSS public abstract interface org.terracotta.toolkit.search.SearchableMap<%0 extends java.lang.Object, %1 extends java.lang.Object>
meth public abstract org.terracotta.toolkit.search.QueryBuilder createQueryBuilder()
meth public abstract void setAttributeExtractor(org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor<{org.terracotta.toolkit.search.SearchableMap%0},{org.terracotta.toolkit.search.SearchableMap%1}>)

CLSS public final !enum org.terracotta.toolkit.search.SortDirection
fld public final static org.terracotta.toolkit.search.SortDirection ASCENDING
fld public final static org.terracotta.toolkit.search.SortDirection DESCENDING
meth public static org.terracotta.toolkit.search.SortDirection valueOf(java.lang.String)
meth public static org.terracotta.toolkit.search.SortDirection[] values()
supr java.lang.Enum<org.terracotta.toolkit.search.SortDirection>

CLSS public abstract interface org.terracotta.toolkit.search.ToolkitSearchQuery
meth public abstract <%0 extends java.lang.Object> java.util.List<{%%0}> getAggregators()
meth public abstract <%0 extends java.lang.Object> java.util.List<{%%0}> getSortAttributes()
meth public abstract <%0 extends java.lang.Object> java.util.Set<{%%0}> getAttributes()
meth public abstract <%0 extends java.lang.Object> java.util.Set<{%%0}> getGroupByAttributes()
meth public abstract boolean requestsKeys()
meth public abstract boolean requestsValues()
meth public abstract int getMaxResults()
meth public abstract org.terracotta.toolkit.search.SearchQueryResultSet execute()

CLSS public org.terracotta.toolkit.search.attribute.NullAttributeExtractor<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor<{org.terracotta.toolkit.search.attribute.NullAttributeExtractor%0},{org.terracotta.toolkit.search.attribute.NullAttributeExtractor%1}>
meth public java.util.Map<java.lang.String,java.lang.Object> attributesFor({org.terracotta.toolkit.search.attribute.NullAttributeExtractor%0},{org.terracotta.toolkit.search.attribute.NullAttributeExtractor%1})
supr java.lang.Object

CLSS public abstract interface org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor<%0 extends java.lang.Object, %1 extends java.lang.Object>
fld public final static java.util.Map DO_NOT_INDEX
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor NULL_EXTRACTOR
meth public abstract java.util.Map<java.lang.String,java.lang.Object> attributesFor({org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor%0},{org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor%1})

CLSS public org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractorException
cons public <init>(java.lang.String)
cons public <init>(java.lang.String,java.lang.Throwable)
cons public <init>(java.lang.Throwable)
intf java.io.Serializable
supr org.terracotta.toolkit.search.SearchException
hfds serialVersionUID

CLSS public abstract !enum org.terracotta.toolkit.search.attribute.ToolkitAttributeType
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType BOOLEAN
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType BYTE
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType CHAR
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType DATE
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType DOUBLE
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType ENUM
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType FLOAT
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType INT
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType LONG
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType SHORT
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType SQL_DATE
fld public final static org.terracotta.toolkit.search.attribute.ToolkitAttributeType STRING
meth public abstract void validateValue(java.lang.String,java.lang.Object)
meth public boolean isComparable()
meth public static boolean isSupportedType(java.lang.Object)
meth public static org.terracotta.toolkit.search.attribute.ToolkitAttributeType typeFor(java.lang.String,java.lang.Object)
meth public static org.terracotta.toolkit.search.attribute.ToolkitAttributeType valueOf(java.lang.String)
meth public static org.terracotta.toolkit.search.attribute.ToolkitAttributeType[] values()
supr java.lang.Enum<org.terracotta.toolkit.search.attribute.ToolkitAttributeType>
hfds MAPPINGS

CLSS public org.terracotta.toolkit.search.expression.Always
cons public <init>()
meth public java.lang.String toString()
supr org.terracotta.toolkit.search.expression.BaseClause

CLSS public abstract org.terracotta.toolkit.search.expression.BaseClause
cons public <init>()
fld protected final static java.lang.String SEP = " "
intf org.terracotta.toolkit.search.expression.Clause
meth public org.terracotta.toolkit.search.expression.BooleanClause and(org.terracotta.toolkit.search.expression.Clause)
meth public org.terracotta.toolkit.search.expression.BooleanClause not()
meth public org.terracotta.toolkit.search.expression.BooleanClause or(org.terracotta.toolkit.search.expression.Clause)
supr java.lang.Object

CLSS public org.terracotta.toolkit.search.expression.BooleanClause
cons public !varargs <init>(org.terracotta.toolkit.search.expression.BooleanClause$Operator,org.terracotta.toolkit.search.expression.Clause[])
innr public final static !enum Operator
intf org.terracotta.toolkit.search.expression.CompositeClause
meth public java.lang.String toString()
meth public org.terracotta.toolkit.search.expression.BooleanClause$Operator type()
meth public org.terracotta.toolkit.search.expression.Clause[] getMembers()
supr org.terracotta.toolkit.search.expression.BaseClause
hfds members,op

CLSS public final static !enum org.terracotta.toolkit.search.expression.BooleanClause$Operator
 outer org.terracotta.toolkit.search.expression.BooleanClause
fld public final static org.terracotta.toolkit.search.expression.BooleanClause$Operator AND
fld public final static org.terracotta.toolkit.search.expression.BooleanClause$Operator NOT
fld public final static org.terracotta.toolkit.search.expression.BooleanClause$Operator OR
meth public static org.terracotta.toolkit.search.expression.BooleanClause$Operator valueOf(java.lang.String)
meth public static org.terracotta.toolkit.search.expression.BooleanClause$Operator[] values()
supr java.lang.Enum<org.terracotta.toolkit.search.expression.BooleanClause$Operator>

CLSS public abstract interface org.terracotta.toolkit.search.expression.Clause
meth public abstract org.terracotta.toolkit.search.expression.Clause and(org.terracotta.toolkit.search.expression.Clause)
meth public abstract org.terracotta.toolkit.search.expression.Clause not()
meth public abstract org.terracotta.toolkit.search.expression.Clause or(org.terracotta.toolkit.search.expression.Clause)

CLSS public abstract interface org.terracotta.toolkit.search.expression.CompositeClause
intf org.terracotta.toolkit.search.expression.Clause
meth public abstract org.terracotta.toolkit.search.expression.Clause[] getMembers()

CLSS public org.terracotta.toolkit.search.expression.Equals
cons public <init>(java.lang.String,java.lang.Object)
meth public java.lang.Object getValue()
meth public java.lang.String getAttributeName()
meth public java.lang.String toString()
supr org.terracotta.toolkit.search.expression.BaseClause
hfds attributeName,value

CLSS public org.terracotta.toolkit.search.expression.Matches
cons public <init>(java.lang.String,java.lang.String)
meth public java.lang.String getAttributeName()
meth public java.lang.String getRegex()
supr org.terracotta.toolkit.search.expression.BaseClause
hfds attributeName,regex

CLSS public org.terracotta.toolkit.search.expression.OneOf
cons public <init>(java.lang.String,java.util.Collection<?>)
meth public java.lang.String getAttributeName()
meth public java.lang.String toString()
meth public java.util.Collection<?> values()
supr org.terracotta.toolkit.search.expression.BaseClause
hfds attributeName,values

CLSS public org.terracotta.toolkit.search.expression.Range
cons public <init>(java.lang.String,java.lang.Object,java.lang.Object,boolean,boolean)
meth public boolean isMaxInclusive()
meth public boolean isMinInclusive()
meth public java.lang.Comparable getMax()
meth public java.lang.Comparable getMin()
meth public java.lang.String getAttributeName()
meth public java.lang.String toString()
supr org.terracotta.toolkit.search.expression.BaseClause
hfds attributeName,max,maxInclusive,min,minInclusive

CLSS public abstract org.terracotta.toolkit.search.expression.RelationalClause
cons protected <init>(java.lang.String,java.lang.String,java.lang.Object)
innr public final static GreaterThan
innr public final static GreaterThanOrEqual
innr public final static LessThan
innr public final static LessThanOrEqual
meth public java.lang.Comparable getValue()
meth public java.lang.String getAttributeName()
meth public java.lang.String toString()
meth public static org.terracotta.toolkit.search.expression.RelationalClause gt(java.lang.String,java.lang.Object)
meth public static org.terracotta.toolkit.search.expression.RelationalClause gte(java.lang.String,java.lang.Object)
meth public static org.terracotta.toolkit.search.expression.RelationalClause lt(java.lang.String,java.lang.Object)
meth public static org.terracotta.toolkit.search.expression.RelationalClause lte(java.lang.String,java.lang.Object)
supr org.terracotta.toolkit.search.expression.BaseClause
hfds attributeName,tag,value

CLSS public final static org.terracotta.toolkit.search.expression.RelationalClause$GreaterThan
 outer org.terracotta.toolkit.search.expression.RelationalClause
cons public <init>(java.lang.String,java.lang.Object)
supr org.terracotta.toolkit.search.expression.RelationalClause

CLSS public final static org.terracotta.toolkit.search.expression.RelationalClause$GreaterThanOrEqual
 outer org.terracotta.toolkit.search.expression.RelationalClause
cons public <init>(java.lang.String,java.lang.Object)
supr org.terracotta.toolkit.search.expression.RelationalClause

CLSS public final static org.terracotta.toolkit.search.expression.RelationalClause$LessThan
 outer org.terracotta.toolkit.search.expression.RelationalClause
cons public <init>(java.lang.String,java.lang.Object)
supr org.terracotta.toolkit.search.expression.RelationalClause

CLSS public final static org.terracotta.toolkit.search.expression.RelationalClause$LessThanOrEqual
 outer org.terracotta.toolkit.search.expression.RelationalClause
cons public <init>(java.lang.String,java.lang.Object)
supr org.terracotta.toolkit.search.expression.RelationalClause

CLSS public abstract interface org.terracotta.toolkit.store.ToolkitConfigFields
fld public final static boolean DEFAULT_COMPRESSION_ENABLED = false
fld public final static boolean DEFAULT_COPY_ON_READ_ENABLED = false
fld public final static boolean DEFAULT_EVICTION_ENABLED = true
fld public final static boolean DEFAULT_LOCAL_CACHE_ENABLED = true
fld public final static boolean DEFAULT_OFFHEAP_ENABLED = false
fld public final static boolean DEFAULT_PINNED_IN_LOCAL_MEMORY = false
fld public final static int DEFAULT_CONCURRENCY = 256
fld public final static int DEFAULT_MAX_COUNT_LOCAL_HEAP = 0
fld public final static int DEFAULT_MAX_TOTAL_COUNT = -1
fld public final static int DEFAULT_MAX_TTI_SECONDS = 0
fld public final static int DEFAULT_MAX_TTL_SECONDS = 0
fld public final static int NO_MAX_TTI_SECONDS = 0
fld public final static int NO_MAX_TTL_SECONDS = 0
fld public final static java.lang.String COMPRESSION_ENABLED_FIELD_NAME = "compressionEnabled"
fld public final static java.lang.String CONCURRENCY_FIELD_NAME = "concurrency"
fld public final static java.lang.String CONSISTENCY_FIELD_NAME = "consistency"
fld public final static java.lang.String COPY_ON_READ_ENABLED_FIELD_NAME = "copyOnReadEnabled"
fld public final static java.lang.String DEFAULT_CONSISTENCY
fld public final static java.lang.String EVICTION_ENABLED_FIELD_NAME = "evictionEnabled"
fld public final static java.lang.String LOCAL_CACHE_ENABLED_FIELD_NAME = "localCacheEnabled"
fld public final static java.lang.String MAX_BYTES_LOCAL_HEAP_FIELD_NAME = "maxBytesLocalHeap"
fld public final static java.lang.String MAX_BYTES_LOCAL_OFFHEAP_FIELD_NAME = "maxBytesLocalOffHeap"
fld public final static java.lang.String MAX_COUNT_LOCAL_HEAP_FIELD_NAME = "maxCountLocalHeap"
fld public final static java.lang.String MAX_TOTAL_COUNT_FIELD_NAME = "maxTotalCount"
fld public final static java.lang.String MAX_TTI_SECONDS_FIELD_NAME = "maxTTISeconds"
fld public final static java.lang.String MAX_TTL_SECONDS_FIELD_NAME = "maxTTLSeconds"
fld public final static java.lang.String OFFHEAP_ENABLED_FIELD_NAME = "offheapEnabled"
fld public final static java.lang.String PINNED_IN_LOCAL_MEMORY_FIELD_NAME = "pinnedInLocalMemory"
fld public final static long DEFAULT_MAX_BYTES_LOCAL_HEAP = 0
fld public final static long DEFAULT_MAX_BYTES_LOCAL_OFFHEAP = 0
innr public final static !enum Consistency

CLSS public final static !enum org.terracotta.toolkit.store.ToolkitConfigFields$Consistency
 outer org.terracotta.toolkit.store.ToolkitConfigFields
fld public final static org.terracotta.toolkit.store.ToolkitConfigFields$Consistency EVENTUAL
fld public final static org.terracotta.toolkit.store.ToolkitConfigFields$Consistency STRONG
fld public final static org.terracotta.toolkit.store.ToolkitConfigFields$Consistency SYNCHRONOUS_STRONG
meth public static org.terracotta.toolkit.store.ToolkitConfigFields$Consistency valueOf(java.lang.String)
meth public static org.terracotta.toolkit.store.ToolkitConfigFields$Consistency[] values()
supr java.lang.Enum<org.terracotta.toolkit.store.ToolkitConfigFields$Consistency>

CLSS public abstract interface org.terracotta.toolkit.store.ToolkitStore<%0 extends java.lang.Object, %1 extends java.lang.Object>
intf java.util.concurrent.ConcurrentMap<{org.terracotta.toolkit.store.ToolkitStore%0},{org.terracotta.toolkit.store.ToolkitStore%1}>
intf org.terracotta.toolkit.object.Destroyable
intf org.terracotta.toolkit.object.ToolkitObject
intf org.terracotta.toolkit.search.SearchableMap<{org.terracotta.toolkit.store.ToolkitStore%0},{org.terracotta.toolkit.store.ToolkitStore%1}>
meth public abstract boolean containsValue(java.lang.Object)
meth public abstract java.util.Map<{org.terracotta.toolkit.store.ToolkitStore%0},{org.terracotta.toolkit.store.ToolkitStore%1}> getAll(java.util.Collection<? extends {org.terracotta.toolkit.store.ToolkitStore%0}>)
meth public abstract org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock createLockForKey({org.terracotta.toolkit.store.ToolkitStore%0})
meth public abstract org.terracotta.toolkit.config.Configuration getConfiguration()
meth public abstract void putNoReturn({org.terracotta.toolkit.store.ToolkitStore%0},{org.terracotta.toolkit.store.ToolkitStore%1})
meth public abstract void removeNoReturn(java.lang.Object)
meth public abstract void setConfigField(java.lang.String,java.io.Serializable)

CLSS public abstract interface !annotation org.terracotta.toolkit.tck.TCKStrict
 anno 0 java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy value=RUNTIME)
 anno 0 java.lang.annotation.Target(java.lang.annotation.ElementType[] value=[TYPE])
intf java.lang.annotation.Annotation

